package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class handles all reading and writing of files
 * Files are stored in the data folder
 */
public abstract class FileHandler {

    /**
     * Write master list of users to file
     * @param users list of users
     */
    public static void writeMasterList(HashMap<String, Citizen> users) {
        try {
            File file = new File("data/masterlist.txt");
            file.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(file);

            users.forEach((username, user) -> {
                if (!username.equals("Admin2020")) {
                    try {
                        writer.write(username + " " + user.getRole() + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to create masterlist.txt. Check folder permissions.");
        }
    }

    /**
     * Read master list data and creates users with their respective roles
     * @param users list of users
     */
    public static void readMasterList(HashMap<String, Citizen> users) {
        File masterList = new File("data/masterlist.txt");
        try {
            Scanner reader = new Scanner(masterList);

            while (reader.hasNextLine()) {
                String username = reader.next();
                String role = reader.next();
                reader.nextLine();

                switch (role) {
                    case "official":
                        users.put(username, new Official(username, "initial123"));
                        break;
                    case "tracer":
                        users.put(username, new Tracer(username, "initial123"));
                        break;
                    case "citizen":
                        users.put(username, new Citizen(username, "initial123"));
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No master list found. New file will be created");
        }
    }

    /**
     * Write users account information to file
     * @param users list of users
     */
    public static void writeAccountInfo(HashMap<String, Citizen> users) {
        users.forEach((username, user) -> {
            if (!username.equals("Admin2020")) {
                try {
                    File file = new File("data/" + username +  ".act");
                    file.getParentFile().mkdirs();
                    FileWriter writer = new FileWriter(file);

                    writer.write(user.getPassword() + "\n" +
                            user.getInfo().getName() + "\n" +
                            "HOME:" + user.getInfo().getHomeAddress() + "\n" +
                            "OFFICE:" + user.getInfo().getOfficeAddress() + "\n" +
                            "PHONE:" + user.getInfo().getPhoneNo() + "\n" +
                            "EMAIL:" + user.getInfo().getEmail() + "\n");

                    writer.close();
                } catch (IOException e) {
                    System.out.println("Unable to create " + user.getUsername() + ".act." + " Check folder permissions.");
                }
            }
        });
    }

    /**
     * Read users account information
     * @param users list of users
     */
    public static void readAccountInfo(HashMap<String, Citizen> users) {
        users.forEach((username, user) -> {
            try {
                Scanner reader = new Scanner(new File( "data/" + username + ".act"));

                user.setPassword(reader.nextLine());
                user.getInfo().setName(reader.nextLine());

                String homeAddress = reader.nextLine().replaceAll("HOME:", "");
                user.getInfo().setHomeAddress(Address.parse(homeAddress));

                String officeAddress = reader.nextLine().replaceAll("OFFICE:", "");
                user.getInfo().setOfficeAddress(Address.parse(officeAddress));

                String phoneNo = reader.nextLine().replaceAll("PHONE:", "");
                user.getInfo().setPhoneNo(Long.parseLong(phoneNo));

                String email = reader.nextLine().replaceAll("EMAIL:", "");
                user.getInfo().setEmail(email);

                reader.close();
            } catch (FileNotFoundException e) {
                System.out.println("No account info found. User will have default information.");
            }
        });
    }

    /**
     * Write users visit records to file
     * @param users list of users
     */
    public static void writeVisitRecord(HashMap<String, Citizen> users) {
        try {
            File file = new File("data/visitrecords.txt");
            file.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(file);

            users.forEach((username, user) -> {
                if (!user.getRecords().isEmpty()) {
                    try {
                        writer.write(username + "\n");
                        for (VisitRecord record : user.getRecords()) {
                            writer.write(record.toString() + "\n");
                        }
                        writer.write("\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to create visitrecords.txt. Check folder permissions.");
        }
    }

    /**
     * Reader visit records of users
     * @param users list of users
     */
    public static void readVisitRecord(HashMap<String, Citizen> users) {
        File visitRecord = new File("data/visitrecords.txt");
        try {
            Scanner reader = new Scanner(visitRecord);

            while (reader.hasNextLine()) {
                String temp = reader.nextLine();
                if (users.containsKey(temp)) {
                    while (reader.hasNextLine()) {
                        String record = reader.nextLine();

                        if (!record.equals("")) {
                            users.get(temp).getRecords().add(VisitRecord.parse(record));
                        } else {
                            break;
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Visit record file not found. New file will be created");
        }
    }

    /**
     * Write cases data to file
     * @param cases list of cases
     */
    public static void writeCases(ArrayList<Case> cases) {
        try {
            File file = new File("data/cases.txt");
            file.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(file);

            for (Case i : cases) {
                writer.write(i.toString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to create cases.txt. Check folder permissions.");
        }
    }

    /**
     * Read cases data
     * @param users list of users
     */
    public static void readCases(HashMap<String, Citizen> users) {
        ArrayList<Case> cases = new ArrayList<>();
        File casesFile = new File("data/cases.txt");

        try {
            Scanner reader = new Scanner(casesFile);

            while (reader.hasNextLine()) {
                Case caseData = Case.parse(reader.nextLine());

                cases.add(caseData);

                // Adds assigned cases to tracers
                if (users.containsKey(caseData.getTracer())) {
                    ((Tracer) users.get(caseData.getTracer())).getAssignedCases().add(caseData);
                }
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Positive cases filed not found. New file will be created");
        }

        // Sets master list of cases
        Official.setCases(cases);
    }
}