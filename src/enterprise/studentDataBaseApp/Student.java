package enterprise.studentDataBaseApp;


import java.util.*;
import enterprise.studentDataBaseApp.LoginSystem;


public class Student {
//    LoginSystem loginSystem = new LoginSystem();
    private String firstName;
    private String lastName;
    private int schoolLevel; //because of number options
    private String convertedLevel;
    private String studentID;
    private List<String> courses = new ArrayList<>();
    private static int tuitionBalance;
    private static int costOfCourse = 600;
    private int tuitionPayed;
    private int numberOfStudents;
    private static int id = 1000;
    public boolean run = true;
    public boolean start = true;
//    private List<String> courses = new ArrayList<>();
//    private int balance;
//    private int tuitionPaid;


    public Student() throws InterruptedException {

        mainJob();

    }

    private void mainJob() throws InterruptedException {
//        loginSystem.userNameValidation();
//        loginSystem.passwordValidation();
        askNumberOfStudents();



        //ask how many students they need to add
        //use scanner to store number of stu they will add
        //run the code below number of times as many stu will be added
        for (int i = 0; i < this.numberOfStudents; i++) {


            Scanner scan = new Scanner(System.in);
            System.out.print("Enter student first name: ");
            firstName = scan.nextLine();

            System.out.print("Enter student last name: ");
            lastName = scan.nextLine();
//            ---------------------- PUT TRY CATCH HERE ------------------- InputMismatchException


            askSchoolLevel();

            setStudentId();


            enroll();
            payTuition();
            System.out.println(showStatus());
            tuitionBalance = 0;


        }

    }


    private void askNames() {
        Scanner scan = new Scanner(System.in);
        if(!firstName.equals(null)) {
            System.out.print("Enter student first name: ");
            firstName = scan.nextLine();
        }



        System.out.print("Enter student last name: ");
        lastName = scan.nextLine();

    }


    private void askSchoolLevel() {



           Scanner levelScan = new Scanner(System.in);
           System.out.print("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior");
           System.out.println("\n===================");
           System.out.println("Enter School Level: ");
           System.out.println("===================");



                try {
                    if (levelScan.hasNextInt()) {
                            schoolLevel = levelScan.nextInt();

                    } else {
                        System.out.println("\n## Please enter a NUMERIC VALUE ##");
                        Scanner level2Scan = new Scanner(System.in);
                        System.out.println("\n===================");
                        System.out.println("REENTER School Level: ");
                        System.out.println("===================");
                        schoolLevel = level2Scan.nextInt();

                    }

                } catch(Exception e) {
                    System.out.println("***********************************");
                    System.out.println("ERROR:" + "\n        THERE HAS BEEN AN EXCEPTION");
                    System.out.println("        PLEASE TRY AGAIN LATER");
                    System.out.println("***********************************");
//                   throw e;
                    System.exit(1); //any number less then zero represents program execution fail

                }


    }


    private void askNumberOfStudents() {
       try {

               Scanner stuScan = new Scanner(System.in);
               System.out.println("How many students will you add: ");
               if (stuScan.hasNextInt()) {
                   numberOfStudents = stuScan.nextInt();
                   if(numberOfStudents == 0) {
                       System.out.println("Have a great day! 😉");
                   }
               } else {
                   System.out.println("\n## Please enter a NUMERIC VALUE ##");
                   Scanner stu2Scan = new Scanner(System.in);
                   System.out.println("\nHow many students will you add: ");
                   numberOfStudents = stu2Scan.nextInt();
               }

       } catch(Exception e) {
           System.out.println("***********************************");
           System.out.println("ERROR:" + "\n        THERE HAS BEEN AN EXCEPTION");
           System.out.println("        PLEASE TRY AGAIN LATER");
           System.out.println("***********************************");
       }
    }



// ---------- Generate an ID ----------

    private void setStudentId() {
        // Grade Level + ID
        id++;
        studentID = schoolLevel + "" + id;
    }


// ---------- Course Enrollment ----------

    public void enroll() {
        // Get inside a loop, user hits q

        do {
            System.out.println("Enter course to enroll (Q to quit): ");
            Scanner eScan = new Scanner(System.in);
            String course = eScan.nextLine().toLowerCase().trim();

            if (!course.equals("q") && !course.equals("Q") && !course.isEmpty()) {
                courses.add(course);
                tuitionBalance = tuitionBalance + costOfCourse; //tuitionBalance += costOfCourse;
            } else if (course.isEmpty()) {
                System.out.println("**You have entered an invalid course**");

            } else {
                break;
            }
        } while (1 != 0);
//        System.out.println("ENROLLED IN: " + courses); //used this just for checking if we had any errors in our code
    }

        public void viewBalance () {
            switch (tuitionBalance) {
                case 0:
                    System.out.println("Your current balance is: $" + tuitionBalance);
                    System.out.println("** Congratulations, all of your Tuition has been paid! **");
                    break;
                default:
                    System.out.println("Your current balance is: $" + tuitionBalance);
                    break;
            }


        }

        public void payTuition () throws InterruptedException {

            isPayTuition();


        }

//        private void minimumTuition (){
//        if (tuitionBalance < 300 && tuitionBalance > 0) {
//            System.out.println("Minimum payment has to be $300");
//        }
//        }


        public void isPayTuition () throws InterruptedException {
            System.out.println("Would you like to pay tuition?");
            Scanner cScan = new Scanner(System.in);
            String ans = cScan.nextLine().toLowerCase();
            if (ans.equals("yes") || ans.equals("y")) {
                do {
                    viewBalance();
                    System.out.println("Enter amount to pay: ");
                    Scanner mScan = new Scanner(System.in);
                    tuitionPayed = mScan.nextInt();
                    tuitionBalance -= tuitionPayed; //tuitionBalance = tuitionBalance - tuitionPayed

                    if (tuitionPayed < 300 && tuitionPayed > 0) {
                        tuitionBalance += tuitionPayed;
                        System.out.println("\n## Minimum payment has to be $300 ##");
                        System.out.println("REENTER amount to pay: ");
                        Scanner m2Scan = new Scanner(System.in);
                        tuitionPayed = m2Scan.nextInt();
                        tuitionBalance -= tuitionPayed;
                    }
                    else if (tuitionBalance < 0) {//100 = 100 - 200
                        System.out.println("** You have paid more than the required amount **");
                        Thread.sleep(1000);
                        System.out.println("  You will be refunded $" + -tuitionBalance);
                        Thread.sleep(1000);
                        tuitionPayed -= -tuitionBalance;
                        tuitionBalance = 0;
                    }
//                System.out.println("==============================");
                    Thread.sleep(1000);
                    System.out.println("## " + "THANK YOU FOR YOUR PAYMENT OF: $" + tuitionPayed + " ##");
//                System.out.println("=============================");
                    Thread.sleep(1000);
                    viewBalance();
                    run = false;
                } while (run);
            } else {
                System.out.println("Okay, got it!");
            }



        }

        private void convertLevel () {
            switch (schoolLevel) {
                case 1:
                    convertedLevel = "Freshmen";
                    break;
                case 2:
                    convertedLevel = "Sophomore";
                    break;
                case 3:
                    convertedLevel = "Junior";
                    break;
                case 4:
                    convertedLevel = "Senior";
                    break;
            }


        }

        private String showStatus () {
            convertLevel();
            return "========== Your Info ========== " +
                    "\nName: " + firstName + " " + lastName +
                    "\nStudent ID: " + studentID +
                    "\nSchool Level: " + convertedLevel +
                    "\nCourses Enrolled:" + courses +
                    "\nBalance: $" + tuitionBalance +
                    "\n====================";


        }



}
