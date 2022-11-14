package controllers;

import views.*;
import models.*;
import java.awt.*;
import java.util.HashMap;

/**
 * This class serves as the controller for the Tracer view
 */
public class TracerController extends CitizenController {

    /**
     * Initializes controller
     * @param users list of users
     */
    public TracerController(HashMap<String, Citizen> users) {
        super(users);
    }

    /**
     * Initializes GUI
     */
    @Override
    public void init() {
        view = new TracerView();
        addBtnListeners();
        view.init(model.getUsername());
        
        if (!hasReported()) {
            view.showCaution(model.getMessage());
        }
    }

    /**
     * Add listeners to view buttons
     */
    @Override
    protected void addBtnListeners() {
        super.addBtnListeners();

        ((TracerView) view).getShowCasesMenuBtn().addActionListener(e -> {
            setActiveMenuBtn(((TracerView) view).getShowCasesMenuBtn());
            if (!showPositiveCases()) {
                view.popUpError("You do not have any pending cases");
                return;
            }
            view.validate();
            view.getLayout().show(view.getDashPanel(), "cases");
        });

        ((TracerView) view).getTraceCaseMenuBtn().addActionListener(e -> {
            setActiveMenuBtn(((TracerView) view).getTraceCaseMenuBtn());
            view.validate();
            view.getLayout().show(view.getDashPanel(), "traceCase");
        });

        ((TracerView) view).getInformBtn().addActionListener(e -> {
            if (!((Tracer) model).getInformList().isEmpty()) {
                setActiveMenuBtn(((TracerView) view).getInformBtn());
                ((Tracer) model).informExposed(users);
                view.popUpSuccess("Informed users exposed.");
            } else {
                view.popUpError("You haven't traced a case yet");
            }
        });

        ((TracerView) view).getTraceBtn().addActionListener(e -> {
            if (!((TracerView) view).getCaseNumField().getText().equals("")) {
                int caseNum = 0;

                try {
                    caseNum = Integer.parseInt(((TracerView) view).getCaseNumField().getText());
                } catch (NumberFormatException err) {
                    view.popUpError("Invalid case number");
                    return;
                }

                if (Official.getCases().get(caseNum - 1).getCaseNum() != caseNum) {
                    System.out.println("Case does not exist");
                    view.popUpError("Case does not exist.");
                    return;
                }

                if (!Official.getCases().get(caseNum - 1).getTracer().equals(model.getUsername())) {
                    view.popUpError("Case is not assigned to you.");
                    return;
                }

                if (Official.getCases().get(caseNum - 1).getStatus() == 'T') {
                    view.popUpError("Case is already traced.");
                    return;
                }

                ((Tracer) model).traceCase(users, caseNum);

                if (showInformList()) {
                    view.validate();
                    view.popUpSuccess("The following users have been exposed.");
                } else {
                    view.popUpError("Unable to find users exposed.");
                }
            }
        });
    }

    /**
     * Add table of positive pending cases assigned to user to the panel
     * @return true if successfully added, false if otherwise
     */
    private boolean showPositiveCases() {
        if (((Tracer) model).getAssignedCases().isEmpty()) {
            return false;
        }

        if (((TracerView) view).getCasesPanel().getComponentCount() > 0) {
            ((TracerView) view).getCasesPanel().remove(0);
        }

        String[][] data = new String[((Tracer) model).getAssignedCases().size()][4];

        for (Case i : ((Tracer) model).getAssignedCases()) {
            if (i.getStatus() == 'P') {
                for (int j = 0; j < data.length; j++) {
                    if (data[j][0] == null) {
                        data[j][0] = i.getCaseNum() + "";
                        data[j][1] = i.getCitizen();
                        data[j][2] = i.getDate() + "";
                        data[j][3] = i.getStatus() + "";
                        break;
                    }
                }
            }
        }

        String[] columnNames = {"Case Number", "Citizen", "Date", "Status"};

        ((TracerView) view).getCasesPanel().add(new Table(data, columnNames));

        return true;
    }

    /**
     * Add table of users possibly exposed to the panel
     * @return true if successfully added, false if otherwise
     */
    private boolean showInformList() {
        if (((Tracer) model).getInformList().isEmpty()) {
            return false;
        }

        if (((TracerView) view).getTracePanel().getComponentCount() > 1) {
            ((TracerView) view).getTracePanel().remove(2);
            ((TracerView) view).getTracePanel().remove(1);
            view.validate();
        }

        String[][] data = new String[((Tracer) model).getInformList().size()][3];

        for (Notice i : ((Tracer) model).getInformList()) {
            for (int j = 0; j < data.length; j++) {
                if (data[j][0] == null) {
                    data[j][0] = i.getUsername();
                    data[j][1] = i.getEstablishment();
                    data[j][2] = i.getDateExposed() + "";
                    break;
                }
            }
        }

        String[] columnNames = {"Names", "Establishment", "Date"};

        ((TracerView) view).getTracePanel().add(new Table(data, columnNames), BorderLayout.CENTER);
        ((TracerView) view).getTracePanel().add(((TracerView) view).getInformBtn(), BorderLayout.SOUTH);

        return true;
    }
}
