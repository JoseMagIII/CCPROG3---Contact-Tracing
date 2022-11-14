import controllers.*;
import models.*;

import java.util.HashMap;

/**
 * Main driver for the application
 * @author Manolo Enriquez
 * @author Jose Maglaque III
 * @version 2.0
 */

public class Main {

    public static void main(String[] args) {
        HashMap<String, Citizen> users = new HashMap<>();

        // Add dummy account
        users.put("Admin2020", new Official("Admin2020", "@Dm1n0202"));

        FileHandler.readMasterList(users);
        FileHandler.readAccountInfo(users);
        FileHandler.readVisitRecord(users);
        FileHandler.readCases(users);

        // Inform exposed citizens on start up
        for (Case i : Official.getCases()) {
            if (i.getStatus() == 'T' && !i.getTracer().equals("000") &&  users.get(i.getTracer()).getRole().equals("tracer")) {
                ((Tracer) users.get(i.getTracer())).traceCase(users, i.getCaseNum());
                ((Tracer) users.get(i.getTracer())).informExposed(users);
            }
        }

        new MainMenuController(users);
    }
}