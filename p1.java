import java.time.LocalDate; //import time library for get local date
import java.util.*; //import util library for get user inputs

class GP { // Main Class
    public static void main(String[] s) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n                                  WELCOME TO GOVERNMENT DOCUMENTS PORTAL");
        System.out.println("                                  --------------------------------------");
        boolean B = true;
        while (B) {
            System.out.println("\n  Enter 1 for AadharCard");
            System.out.println("\n  Enter 2 for Driving Licence");
            System.out.println("\n  Enter 3 for PAN Card");
            System.out.println("\n  Enter 4 for VoterID Card");
            System.out.println("\n  Enter 5 for Ration Card");
            System.out.println("\n  Enter 6 for Exit");
            int choise = sc.nextInt();
            switch (choise) {
                case 1:
                    AadharCard A = new AadharCard(); // Making Object of AdharCard class
                    A.main(); // calling main method of object
                    break;

                case 2:
                    DrivingLicence D = new DrivingLicence(); // Making Object of DrivingLicence class
                    D.main(); // calling main method of object
                    break;

                case 3:
                    PANCardManagementSystem P = new PANCardManagementSystem(); // Making Object of P
                    P.main(); // calling main method of object
                    break;

                case 4:
                    VoterID V = new VoterID();
                    V.main(); // calling main method of object
                    break;

                case 5:
                    RationCard R = new RationCard();
                    R.main();
                    break;

                case 6:
                    System.out.println("Thank  You For Visit. Feel Free To Return AnyTime.");
                    B = false;
                    break;

                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
}

class AadharCard { // AadharCard Main Class
    Scanner sc = new Scanner(System.in);
    String firstName, middleName, lastName;
    String aadharNumber;
    String DoB;
    String gender;

    public void getData() {
        System.out.println("ENTER YOUR FIRST NAME:");
        firstName = sc.next();

        System.out.println("ENTER YOUR MIDDLE NAME:");
        middleName = sc.next();

        System.out.println("ENTER YOUR LAST NAME:");
        lastName = sc.next();

        System.out.println("ENTER YOUR BIRTH OF DATE FORMAT DD/MM/YYYY:");
        DoB = sc.next();

        boolean g = true;
        while (g) {
            System.out.print("ENTER YOUR GENDER : ENTER 1 FOR MALE; 2 FOR FEMALE; 3 FOR OTHERS : ");
            int ch = sc.nextInt();
            if (ch == 1) {
                gender = "MALE";
                g = false;
            } else if (ch == 2) {
                gender = "FEMALE";
                g = false;
            } else if (ch == 3) {
                gender = "OTHERS";
                g = false;
            } else {
                System.out.println("ENTER PROPER NUMBER");
            }
        }
        setAdhar();
    }

    void setAdhar() {
        aadharNumber = Long.toString((long) (Math.random() * 1000000000000L));
    }

    void display() {
        System.out.println(
                " NAME: " + firstName.toUpperCase() + " " + middleName.toUpperCase() + " " + lastName.toUpperCase());
        System.out.print(" DoB = " + DoB);
        System.out.println(" GENDER = " + gender);
        System.out.println("\n     " + aadharNumber + "   ");
        System.out.println();

    }

    void search(String AadharNumber) {
        if (aadharNumber.equals(AadharNumber)) {
            display();
        } else {
            System.out.println("WRONG ADHARCARD NUMBER");
        }
    }

    void modify(String madhar) {
        if (madhar.equals(aadharNumber)) {
            System.out.println("ENTER NEW YOUR FIRST NAME:");
            String newfirstName = sc.next();
            firstName = newfirstName;

            System.out.println("ENTER NEW YOUR MIDDLE NAME:");
            String newmiddleName = sc.next();
            middleName = newmiddleName;

            System.out.println("ENTER NEW YOUR LAST NAME:");
            String newlastName = sc.next();
            lastName = newlastName;

            System.out.println("ENTER NEW YOUR BIRTH OF DATE FORMAT DD/MM/YYYY:");
            String newBod = sc.next();
            DoB = newBod;
        } else {
            System.out.println(" INVELID ADHARCARD NUMBER ");
        }
    }

    public static void main() { // AadharCard main Method
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Total ADHARCARD TO GENERATE : ");
        int n = sc.nextInt();
        AadharCard s1[] = new AadharCard[n];
        for (int i = 0; i < s1.length; i++) {
            System.out.println();
            System.out.println("------------------------------------------------------------");
            System.out.println("ADHARCARD NUMBER : " + (i + 1));
            s1[i] = new AadharCard();
            s1[i].getData();
        }
        boolean k = true;
        while (k) {
            System.out.println("------------------------------------------------------------");
            System.out.println("ENTER 1 FOR DISPLAY ");
            System.out.println("ENTER 2 FOR SEARCH");
            System.out.println("ENTER 3 FOR MODIFY");
            System.out.println("ENTER 4 FOR EXIT ");
            System.out.println("ENTER YOUR CHIOCE : ");
            String h = sc.next();
            switch (h) {
                case "1": {
                    for (int i = 0; i < n; i++) {
                        s1[i].display();
                    }
                    break;
                }
                case "2": {
                    System.out.println("ENTER AADHAR NUMBER YOU WANT TO  SEARCH : ");
                    String AdharNumber = sc.next();
                    for (int i = 0; i < n; i++) {
                        s1[i].search(AdharNumber);
                    }
                    break;
                }
                case "3": {
                    System.out.println("ENTER ADHARCARD NUMBER YOU WONT TO MODIFY =");
                    String madhar = sc.next();
                    for (int i = 0; i < n; i++) {
                        s1[i].modify(madhar);
                    }
                    break;
                }
                case "4": {
                    k = false;
                    break;
                }
                default: {
                    System.out.println("INVELID INPUT ");
                }
            }
        }
    }
}

class MainDL { // Driving Licence Processing
    Scanner sc = new Scanner(System.in);
    String name, gender, mobile, aadhar, state, b_group, donor, dob, vehicle_class, DL_no;
    LocalDate DoB;
    LocalDate currentDate = LocalDate.now();
    int Age;

    public void getdata() {
        System.out.println("                                                  DRIVING LICENCE REGISTRATION");
        String fn, sn, ln;
        System.out.print("Enter Your First Name : ");
        fn = sc.next();
        System.out.print("Enter Your Second Name : ");
        sn = sc.next();
        System.out.print("Enter Your Last Name : ");
        ln = sc.next();
        name = fn.toUpperCase() + " " + sn.toUpperCase() + " " + ln.toUpperCase();
        System.out.print("Enter Your Date Of Birth in 'YYYY-MM-DD' format : ");
        dob = sc.next();

        getMobile();

        boolean a = true;
        while (a) {
            System.out.print("Enter Your Aadhar Card Number : ");
            aadhar = sc.next();
            if (aadhar.length() == 12) {
                int j = 0;
                for (j = 0; j < aadhar.length(); j++) {
                    if (aadhar.charAt(j) >= '0' && aadhar.charAt(j) <= '9')
                        continue;
                    else
                        System.out.println("Enter Number Properly");
                    break;
                }
                if (j == 12) {
                    a = false;
                }
            } else {
                System.out.println("Aadhar Number Must Be of 12 Digits Only");
            }
        }

        System.out.print("Enter Your State Name : ");
        state = sc.next();
        state = state.toUpperCase();
        System.out.print("Enter Your Gender : Enter 1 for male; 2 for female; 3 for others : ");
        boolean b = true;
        while (b) {
            int g = sc.nextInt();
            if (g == 1) {
                gender = "Male";
                b = false;
            } else if (g == 2) {
                gender = "Female";
                b = false;
            } else if (g == 3) {
                gender = "Others";
                b = false;
            } else {
                System.out.println("Enter proper number");
            }
        }
        boolean d = true;
        while (d) {
            System.out.println("\nEnter 1 If You Know Your Blood Group");
            System.out.println("Enter 2 If You Don't Know Your Blood Group");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: // case:1 for enter blood group
                    System.out.println("Enter 1 for A+ ");
                    System.out.println("Enter 2 for A- ");
                    System.out.println("Enter 3 for B+");
                    System.out.println("Enter 4 for B- ");
                    System.out.println("Enter 5 for AB+ ");
                    System.out.println("Enter 6 for AB- ");
                    System.out.println("Enter 7 for O+ ");
                    System.out.println("Enter 8 for O-");
                    int bg = sc.nextInt();
                    switch (bg) {
                        // choose blood group from below
                        case 1:
                            b_group = "A+";
                            break;
                        case 2:
                            b_group = "A-";
                            break;
                        case 3:
                            b_group = "B+";
                            break;
                        case 4:
                            b_group = "B-";
                            break;
                        case 5:
                            b_group = "AB+";
                            break;
                        case 6:
                            b_group = "AB-";
                            break;
                        case 7:
                            b_group = "O+";
                            break;
                        case 8:
                            b_group = "O-";
                            break;
                    }
                    d = false;
                    break;
                case 2: // case:2 for unknown blood group
                    b_group = " ";
                    d = false;
                    break;
                default: // default for invalid choise
                    System.out.println("Please Enter Number Properly : ");
                    break;
            }
        }
        System.out.print("Are You Organ Donor? (enter 1 for yes; 2 for no) : ");
        int don = sc.nextInt();
        if (don == 1) {
            donor = "Yes";
        } else {
            donor = "No";
        }

        boolean e = true;
        while (e) {
            System.out.print("Enter Class of Vehicle : enter 1 for MCWOG and enter 2 for MCWG : ");
            int cov = sc.nextInt();
            if (cov == 1) {
                vehicle_class = "MCWOG";
                e = false;
            } else if (cov == 2) {
                vehicle_class = "MCWG";
                e = false;
            } else {
                System.out.println("Enter Proper Number");
            }
        }
    }

    public void getMobile() {
        boolean c = true;
        while (c) {
            System.out.print("Enter Your Mobile Number : ");
            mobile = sc.next();
            int k = 0;
            if (mobile.length() == 10) {
                for (k = 0; k < mobile.length(); k++) {
                    if (mobile.charAt(k) >= '0' && mobile.charAt(k) <= '9') {
                        continue;
                    } else {
                        System.out.println("Enter Number Properly");
                        break;
                    }
                }
            }
            if (k == mobile.length()) {
                c = false;
            } else {
                System.out.println("Enter Proper Mobile Number; And First Digit Must Be 9 or 8. ");
            }
        }
    }

    public void generate() {
        int year = currentDate.getYear();
        DL_no = state.substring(0, 1) + this.state.substring(2, 3) + Integer.toString(year)
                + Integer.toString((int) (Math.random() * 20000000));
        Age = age_calc();
    }

    public int age_calc() {
        DoB = LocalDate.parse(dob);
        // Age = age_calc();
        if (DoB != null && currentDate != null) {
            int age = currentDate.getYear() - DoB.getYear();
            if (currentDate.isBefore(DoB.plusYears(age))) {
                age--;
            }
            return age;
        } else {
            return 0;
        } // for invalid date
    }

    public void checkAge() {
        if (vehicle_class.equals("MCWOG") && Age < 16) {
            System.out.println("Sorry! You Are Not Eligible For Licence(MCWOG) At This Age.");
        } else if (vehicle_class.equals("MCWG") && Age < 18) {
            System.out.println("Sorry! You Are Not Eligible For Licence(MCWG) At This Age.");
        } else {
            System.out.println("You Are Eligible For Get Licence. ");
            getResult();
        }
    }

    public void getResult() {
        System.out.println("\nWhat Is Your Driving Test Result?");
        System.out.print("Enter 1 for Pass and Enter 2 for Fail : ");
        boolean f = true;
        while (f) {
            int r = sc.nextInt();
            if (r == 1) {
                System.out.println("Congratulations! You Passed The Test. Here Is Your Licence : ");
                display_DL();
                f = false;
            } else if (r == 2) {
                System.out.println("You Can Give ReTest After 7 Days.");
                f = false;
            } else {
                System.out.println("Enter Proper Number.");
            }
        }
    }

    public void display_DL() {

        System.out.println(
                "-------------------------------------------------------------------------------------------------------");

        System.out.println("                                           DRIVING  LICENCE ");
        System.out.println("                                           ----------------");
        System.out.println("\nDriving Licence Number : " + DL_no);
        System.out.print("\nIssue Date : " + currentDate + "                  ");
        System.out.println("Valid UpTo : " + currentDate.plusYears(20));
        System.out.println("                                         -----------------------");
        System.out.print("Licence Holder Name : " + name);
        System.out.println("                             Gender : " + gender);
        System.out.print("\nDate Of Birth : " + DoB + "                 ");
        System.out.print("Blood Group : " + b_group + "                ");
        System.out.println("Organ Donor : " + donor);
        System.out.println("\nClass Of Vehicle : " + vehicle_class);
        System.out.println("\nContact Number : " + mobile);
        System.out.println(
                "-------------------------------------------------------------------------------------------------------");
    }

    public void update_DL() {
        System.out.println("What Do You Want To Update? ");
        System.out.print("Enter 1 for Class Of Vehicle And 2 for Contact Number : ");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                boolean g = true;
                while (g) {
                    System.out.print("Enter Updated Class of Vehicle : enter 1 for MCWOG and enter 2 for MCWG : ");
                    int cov = sc.nextInt();
                    if (cov == 1) {
                        vehicle_class = "MCWOG";
                        g = false;
                    } else if (cov == 2) {
                        vehicle_class = "MCWG";
                        g = false;
                    } else {
                        System.out.println("Enter Proper Number");
                    }
                }
                break;

            case 2:
                boolean c = true;
                while (c) {
                    System.out.print("Enter Your Mobile Number : ");
                    mobile = sc.next();
                    int k = 0;
                    if (mobile.length() == 10) {
                        for (k = 0; k < mobile.length(); k++) {
                            if (mobile.charAt(k) >= '0' && mobile.charAt(k) <= '9') {
                                continue;
                            } else {
                                System.out.println("Enter Number Properly");
                                break;
                            }
                        }
                    }
                    if (k == mobile.length() && mobile.charAt(0) >= '7') {
                        c = false;
                    } else {
                        System.out.println("Enter Proper Mobile Number ");
                    }

                }
                break;
            default:
                System.out.println("invalid");
        }
        System.out.println("\nHere Is Your Updated Driving Licence : ");
        display_DL();
    }
}

class DrivingLicence { // Driving Licence Main Class
    static MainDL drive = new MainDL();
    static Scanner sc = new Scanner(System.in);
    static MainDL a[] = null;

    public static void main() { // Driving Licence main Method
        System.out.println("                         DRIVING LICENCE MANAGEMENT SYSTEM");
        boolean h = true;
        while (h) {
            System.out.println("\nEnter 1 For Generate DL");
            System.out.println("Enter 2 For Print DL");
            System.out.println("Enter 3 For Update DL");
            System.out.println("Enter 4 For Exit");

            System.out.print("Enter Your Choice : ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("How many DLs do you want to generate?");
                    int n = sc.nextInt();
                    a = new MainDL[n]; // Initialize the array
                    for (int i = 0; i < n; i++) {
                        a[i] = new MainDL();
                        System.out.println("License no : " + (i + 1));
                        a[i].getdata();
                        a[i].generate();
                        a[i].age_calc();
                        a[i].checkAge();
                    }
                    break;
                case 2:
                    if (a == null) {
                        System.out.println("No Driving Licences have been generated yet.");
                    } else {
                        System.out.print("Enter the Driving Licence Number (DL_no) to print: ");
                        String dlToPrint = sc.next();
                        boolean found = true;
                        for (MainDL dl : a) {
                            if (dl.DL_no.equals(dlToPrint)) {
                                dl.display_DL();
                                found = false;
                                break;
                            }
                        }
                        if (found) {
                            System.out.println("Driving Licence with DL_no " + dlToPrint + " Not Found.");
                        }
                    }
                    break;

                case 3:
                    if (a == null) {
                        System.out.println("No Driving Licences Have Been Generated Yet.");
                    } else {
                        System.out.print("Enter The Driving Licence Number (DL_no) To Update: ");
                        String dlToUpdate = sc.next();
                        boolean found = true;
                        for (MainDL dl : a) {
                            if (dl.DL_no.equals(dlToUpdate)) {
                                dl.update_DL();
                                found = false;
                                break;
                            }
                        }
                        if (found) {
                            System.out.println("Driving License with DL_no " + dlToUpdate + " not found.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Program Terminated. Drive Safely !");
                    h = false; // exit
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
                    break;
            }
        }
    }
}

class PANCard { // PAN Card Processing
    String firstName;
    String middleName;
    String lastName;
    String fatherFirstName;
    String fatherMiddleName;
    String fatherLastName;
    String dateOfBirth;
    String panNumber;
    String mobileNumber;

    public PANCard(String firstName, String middleName, String lastName, String fatherFirstName,
            String fatherMiddleName,
            String fatherLastName, String dateOfBirth, String panNumber, String mobileNumber) {
        this.firstName = firstName.trim();
        this.middleName = middleName.trim();
        this.lastName = lastName.trim();
        this.fatherFirstName = fatherFirstName.trim();
        this.fatherMiddleName = fatherMiddleName.trim();
        this.fatherLastName = fatherLastName.trim();
        this.dateOfBirth = dateOfBirth;
        this.panNumber = panNumber;
        this.mobileNumber = mobileNumber.trim();
    }

    public void displayDetails() {
        System.out.println("\nPAN Card Details:");
        System.out.println("Applicant's Name: " + firstName + " " + middleName + " " + lastName);
        System.out.println("Father's Name: " + fatherFirstName + " " + fatherMiddleName + " " + fatherLastName);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("PAN Number: " + panNumber);
        System.out.println("Mobile Number: " + mobileNumber);
    }

    public void printDetails() {
        System.out.println("\n************************* PAN Card *********************************");
        System.out.println("  INCOME TAX DEPARTMENT                          GOVT. OF INDIA   ");
        System.out.println("  Name: " + firstName + " " + middleName + " " + lastName);
        System.out.println("  Father's Name: " + fatherFirstName + " " + fatherMiddleName + " " + fatherLastName);
        System.out.println("  Date of Birth: " + dateOfBirth + "                                      ");
        System.out.println("  PAN Number: " + panNumber + "                                         ");
        System.out.println();
        System.out.println("  Signature                                                      ");
        System.out.println("********************************************************************");
    }

    String getPanNumber() {
        return panNumber;
    }

    String getMobileNumber() {
        return mobileNumber;
    }

    void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber.trim();
    }

    void updateFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    void updateMiddleName(String middleName) {
        this.middleName = middleName.trim();
    }

    void updateLastName(String lastName) {
        this.lastName = lastName.trim();
    }

    void updateFatherFirstName(String fatherFirstName) {
        this.fatherFirstName = fatherFirstName.trim();
    }

    void updateFatherMiddleName(String fatherMiddleName) {
        this.fatherMiddleName = fatherMiddleName.trim();
    }

    void updateFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName.trim();
    }

    void updateDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

class PANCardManagementSystem { // PAN Card main class
    static Scanner scanner = new Scanner(System.in);
    static PANCard[] panCards = new PANCard[100];
    static int panCardCount = 0;

    static String getUserInput(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine().toUpperCase();
    }

    static PANCard applyForPANCard() {
        System.out.println("\nApplying for a new PAN Card:");

        String firstName = getUserInput("Enter First Name");
        String middleName = getUserInput("Enter Middle Name");
        String lastName = getUserInput("Enter Last Name");
        String dateOfBirth = getUserInput("Enter Date of Birth (DD/MM/YYYY)");
        String fatherFirstName = getUserInput("Enter Father's First Name");
        String fatherMiddleName = getUserInput("Enter Father's Middle Name");
        String fatherLastName = getUserInput("Enter Father's Last Name");
        while (!isValidDateFormat(dateOfBirth)) {
            System.out.println("Invalid date format. Please enter date in DD/MM/YYYY format.");
            dateOfBirth = getUserInput("Enter Date of Birth (DD/MM/YYYY)");
        }
        String panNumber = generatePANNumber();
        String mobileNumber = getUserInput("Enter Mobile Number");
        while (!isValidMobileNumber(mobileNumber)) {
            System.out.println("Invalid mobile number. Please enter a 10-digit number.");
            mobileNumber = getUserInput("Enter Mobile Number");
        }

        return new PANCard(firstName, middleName, lastName, fatherFirstName, fatherMiddleName, fatherLastName,
                dateOfBirth, panNumber, mobileNumber);
    }

    static boolean isValidDateFormat(String date) {
        return date.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    static boolean isValidMobileNumber(String number) {
        return number.matches("\\d{10}");
        // The .matches() method is a method available in Java's String class.
        // number is a String object that presumably contains a sequence of characters
        // representing a potential mobile phone number.
    }

    static String generatePANNumber() {
        /*
         * PAN number
         * PAN has a typical format of ABCTY1234D. The first three characters, i.e.
         * 'ABC' in
         * the above number is an alphabetic series ranging between AAA and ZZZ. The 4th
         * character,
         * i.e. 'T', represents the PAN holder's status. The alphabet 'T' represents
         * Trust, 'F'
         * for Firm, 'H' for HUF, 'P' for Individual, 'C' for Company etc
         */
        String panNumber = "";
        // First 5 characters
        for (int i = 0; i < 10; i++) {
            if (i == 5 || i == 6 || i == 7 || i == 8) {
                panNumber += (int) (Math.random() * 10);
            } else {
                panNumber += (char) ('A' + (int) (Math.random() * 26));
            }
        }
        return panNumber;
    }

    static void displayPANCardDetails(String panNumber) {
        boolean found = false;
        for (int i = 0; i < panCardCount; i++) {
            if (panCards[i].getPanNumber().equals(panNumber)) {
                panCards[i].displayDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No PAN card found with number " + panNumber);
        }
    }

    static void printPANCardDetails(String panNumber) {
        boolean found = false;
        for (int i = 0; i < panCardCount; i++) {
            if (panCards[i].getPanNumber().equals(panNumber)) {
                panCards[i].printDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No PAN card found with number " + panNumber);
        }
    }

    static PANCard findPANCardByMobileNumber(String mobileNumber) {
        for (int i = 0; i < panCardCount; i++) {
            if (panCards[i].getMobileNumber().equals(mobileNumber)) {
                return panCards[i];
            }
        }
        return null;
    }

    static void updatePANCardInformation(String panNumber) {
        for (int i = 0; i < panCardCount; i++) {
            if (panCards[i].getPanNumber().equals(panNumber)) {
                System.out.println("\nUpdate PAN Card Information:");
                System.out.println("1. First Name");
                System.out.println("2. Middle Name");
                System.out.println("3. Last Name");
                System.out.println("4. Father's First Name");
                System.out.println("5. Father's Middle Name");
                System.out.println("6. Father's Last Name");
                System.out.println("7. Date of Birth");
                System.out.println("8. Cancel");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        panCards[i].updateFirstName(getUserInput("Enter New First Name"));
                        break;
                    case 2:
                        panCards[i].updateMiddleName(getUserInput("Enter New Middle Name"));
                        break;
                    case 3:
                        panCards[i].updateLastName(getUserInput("Enter New Last Name"));
                        break;
                    case 4:
                        panCards[i].updateFatherFirstName(getUserInput("Enter New Father's First Name"));
                        break;
                    case 5:
                        panCards[i].updateFatherMiddleName(getUserInput("Enter New Father's Middle Name"));
                        break;
                    case 6:
                        panCards[i].updateFatherLastName(getUserInput("Enter New Father's Last Name"));
                        break;
                    case 7:
                        String dob;
                        do {
                            dob = getUserInput("Enter New Date of Birth (DD/MM/YYYY)");
                            if (!isValidDateFormat(dob)) {
                                System.out.println("Invalid date format. Please enter date in DD/MM/YYYY format.");
                            }
                        } while (!isValidDateFormat(dob));
                        panCards[i].updateDateOfBirth(dob);
                        break;
                    case 8:
                        System.out.println("Update cancelled.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
                return;
            }
        }
        System.out.println("No PAN card found with number " + panNumber);
    }

    public static void main() { // PAN Card main Method
        boolean b = true;
        while (b) {

            System.out.println("\n                                             PAN CARD MANAGEMENT SYSTEM");
            System.out.println("1. Apply for PAN Card");
            System.out.println("2. Display PAN Card Details");
            System.out.println("3. Print PAN Card");
            System.out.println("4. Find PAN Card by Mobile Number");
            System.out.println("5. Update PAN Card Information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.next();
            scanner.nextLine();

            switch (choice) {
                case "1":
                    if (panCardCount < panCards.length) {
                        panCards[panCardCount++] = applyForPANCard();
                        System.out.println("PAN Card successfully applied.");
                    } else {
                        System.out.println("Cannot apply for PAN card. Maximum limit reached.");
                    }
                    break;
                case "2":
                    System.out.print("Enter PAN Number to display details: ");
                    String panNumber = scanner.nextLine().trim();
                    displayPANCardDetails(panNumber);
                    break;
                case "3":
                    System.out.print("Enter PAN Number to print details: ");
                    String panToPrint = scanner.nextLine().trim();
                    printPANCardDetails(panToPrint);
                    break;
                case "4":
                    System.out.print("Enter Mobile Number to find PAN Card: ");
                    String mobileNumber;
                    do {
                        mobileNumber = scanner.nextLine().trim();
                        if (mobileNumber.length() != 10 || !mobileNumber.matches("\\d+")) {
                            System.out.println("Invalid mobile number. Please enter a 10-digit number.");
                            System.out.print("Enter Mobile Number: ");
                        }
                    } while (mobileNumber.length() != 10 || !mobileNumber.matches("\\d+"));
                    PANCard foundPANCard = findPANCardByMobileNumber(mobileNumber);
                    if (foundPANCard != null) {
                        foundPANCard.displayDetails();
                    } else {
                        System.out.println("No PAN card found with mobile number " + mobileNumber);
                    }
                    break;
                case "5":
                    System.out.print("Enter PAN Number to update information: ");
                    String panToUpdate = scanner.nextLine().trim();
                    updatePANCardInformation(panToUpdate);
                    break;
                case "6":
                    System.out.println("Exiting PAN Card Management System. Goodbye!");
                    b = false;
					break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
					break;
            }
        }
    }
}

class Voter { // VoterID Processing
    String firstName, middleName, lastName;
    String fatherFirstName, fatherMiddleName, fatherLastName;
    String address;
    int age;
    int voterID;

    public Voter(String firstName, String middleName, String lastName, int age, String fatherFirstName,
            String fatherMiddleName, String fatherLastName, String address, int voterID) {
        this.firstName = firstName.toUpperCase();
        this.middleName = middleName.toUpperCase();
        this.lastName = lastName.toUpperCase();
        this.age = age;
        this.fatherFirstName = fatherFirstName.toUpperCase();
        this.fatherMiddleName = fatherMiddleName.toUpperCase();
        this.fatherLastName = fatherLastName.toUpperCase();
        this.address = address;
        this.voterID = voterID;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public String getFatherFullName() {
        return fatherFirstName + " " + fatherMiddleName + " " + fatherLastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getVoterID() {
        return voterID;
    }

    public boolean isEligibleToVote() {
        // Adjust the voting age based on your country's regulations
        int votingAge = 18;
        return age >= votingAge;
    }
}

class VoterID { // VoterID Main Class
    public static void main() { // VoterID main Method
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n                         VOTERID CARD MANGEMENT SYSTEM");
        System.out.print("Enter the number of voters: ");
        int numVoters = scanner.nextInt();

        Voter[] voters = new Voter[numVoters]; // Array to store voter objects

        for (int i = 0; i < numVoters; i++) {
            System.out.println("\nEnter details for voter " + (i + 1) + ":");

            System.out.print("Enter first name: ");
            String firstName = scanner.next().toUpperCase();

            System.out.print("Enter middle name: ");
            String middleName = scanner.next().toUpperCase();

            System.out.print("Enter last name: ");
            String lastName = scanner.next().toUpperCase();

            System.out.print("Enter age: ");
            int age = scanner.nextInt();

            scanner.nextLine(); // Consume newline left-over
            System.out.print("Enter father's first name: ");
            String fatherFirstName = scanner.next().toUpperCase();

            System.out.print("Enter father's middle name: ");
            String fatherMiddleName = scanner.next().toUpperCase();

            System.out.print("Enter father's last name: ");
            String fatherLastName = scanner.next().toUpperCase();

            scanner.nextLine(); // Consume newline left-over
            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            double random = Math.random() * 8249796;
            int voterID = (int) random;

            voters[i] = new Voter(firstName, middleName, lastName, age, fatherFirstName, fatherMiddleName,
                    fatherLastName, address, voterID);
        }

        System.out.println("\n---------------------------------------------------");
        System.out.println("Voter Information:");
        for (int i = 0; i < numVoters; i++) {
            Voter voter = voters[i];
            System.out.println("\nVoter " + (i + 1) + " Details:");
            System.out.println("Name: " + voter.getFullName());
            System.out.println("Age: " + voter.getAge());
            System.out.println("Father's Name: " + voter.getFatherFullName());
            System.out.println("Address: " + voter.getAddress());
            if (voter.isEligibleToVote()) {
                System.out.println("Eligible to vote: Yes");
                System.out.println("Voter ID: " + voter.getVoterID());

            } else {
                System.out.println("Eligible to vote: No");
            }
        }
    }
}

class RationCard // Ration Card main class
{
    public static void main() { // Ration Card main Method
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER TOTAL RATION CARD TO ADD ");
        int n = sc.nextInt();
        RationCard r1[] = new RationCard[n];
        for (int i = 0; i < r1.length; i++) {
            System.out.println("RATIONCARD NUMBER " + (i + 1));
            r1[i] = new RationCard();
            r1[i].setdata();
        }
        boolean t = true;
        while (t) {
            System.out.println("ENTER 1 FOR DISPALY ");
            System.out.println("ENTER 2 FOR MODIFY");
            System.out.println("ENTER 3 FOR EXIT ");
            System.out.println("ENTER YOUR CHIOCE =");
            int o = sc.nextInt();
            switch (o) {
                case 1: {
                    for (int i = 0; i < n; i++) {
                        System.out.print("ration card " + (i + 1));
                        r1[i].detaile();
                    }
                    break;
                }
                case 2: {
                    for (int i = 0; i < n; i++) {
                        r1[i].update();
                    }
                    break;
                }
                case 3: {
                    t = false;
                    break;
                }
            }
        }
    }

    Scanner sc = new Scanner(System.in);
    String mobile_number;
    String Address;
    String son_name;
    String Father_name;
    String Mother_name;

    void setdata() {
        System.out.println("ENTER YOUR FATHER NAME ");
        Father_name = sc.next();

        System.out.println("ENTER YOUR MOBILE NUMBER ");
        mobile_number = sc.next();

        System.out.println("ENTER YOUR MOTHER NAME ");
        Mother_name = sc.next();

        System.out.println("ENTER YOUR SON NAME ");
        son_name = sc.next();

        System.out.println("ENTER YOUR ADDRESS ");
        Address = sc.next();
    }

    int update() {
        int b = 0;
        boolean b1 = true;
        while (b1) {
            System.out.println("ENTER 1 FOR YOUR FATHER NAME ");

            System.out.println("ENTER 2 FOR YOUR MOBILE NUMBER ");

            System.out.println("ENTER 3 FOR YOUR MOTHER NAME ");

            System.out.println("ENTER 4 FOR YOUR SON NAME ");

            System.out.println("ENTER 5 FOR YOUR ADDRESS ");

            System.out.println("ENTER 6 FOR EXIT");

            System.out.println("ENTER 7 FOR CHECK ALL DETAILS");

            System.out.println("ENTER YOUR CHOICE = ");
            b = sc.nextInt();

            switch (b) {
                case 1: {
                    sc.nextLine();
                    System.out.println("ENTER UPDATE FATHER NAME =");
                    String newFather_name = sc.next();
                    Father_name = newFather_name;
                    Dataprint(b);
                    break;
                }

                case 2: {
                    System.out.println("ENTER UPDATE MOBILE NUMBER =");
                    String newmobile_number = sc.next();
                    mobile_number = newmobile_number;
                    Dataprint(b);
                    break;
                }

                case 3: {
                    System.out.println("ENTER UPDATE MOTHER NAME =");
                    String newMother_name = sc.next();
                    Mother_name = newMother_name;
                    Dataprint(b);
                    break;
                }

                case 4: {
                    System.out.println("ENTER UPDATE SON NAME =");
                    String newson_name = sc.next();
                    son_name = newson_name;
                    Dataprint(b);
                    break;

                }

                case 5: {
                    System.out.println("ENTER UPDATE ADDRESS =");
                    String newAddress = sc.next();
                    Address = newAddress;
                    Dataprint(b);
                    break;
                }

                case 6: {
                    b1 = false;
                    break;
                }

                case 7: {
                    detaile();
                    break;
                }

                default: {
                    System.out.println(" INVELID CHOICE ");
                    break;
                }
            }
        }
        return b;
    }

    void Dataprint(int n) {
        switch (n) {
            case 1: {
                System.out.println("YOUR UPDATED FATHER NAME IS =" + Father_name);
                break;
            }

            case 2: {
                System.out.println("YOUR UPDATED MOBILE NUMBER IS =" + mobile_number);
                break;
            }

            case 3: {
                System.out.println("YOUR UPDATED MOTHER NAME IS =" + Mother_name);
                break;
            }

            case 4: {
                System.out.println("YOUR UPDATED SON NAME IS =" + son_name);
                break;
            }

            case 5: {
                System.out.println("YOUR UPDATED ADDRESS IS =" + Address);
                break;
            }
        }
    }

    void detaile() {
        System.out.println("YOUR FATHER NAME IS =" + Father_name);

        System.out.println("YOUR MOBILE NUMBER IS =" + mobile_number);

        System.out.println("YOUR MOTHER NAME IS =" + Mother_name);

        System.out.println("YOUR SON NAME IS =" + son_name);

        System.out.println("YOUR ADDRESS IS =" + Address);
    }
}