package enterprise.studentDataBaseApp;

import java.util.Scanner;

public class LoginSystem {

    private String userPassword;
    private String userName;


    public LoginSystem() {

        userNameValidation();
        passwordValidation();

    }

    public void userNameValidation() {

        System.out.println("-------------------------");
        System.out.println("**Account Registration**");
        System.out.println("-------------------------");
        System.out.println("Username: ");
        Scanner scanUserName = new Scanner(System.in);
        String userName = scanUserName.nextLine();

    }

    public void passwordValidation() {
            boolean b = true;
            while(true) {
                System.out.println("Password: ");
                Scanner scanPassword = new Scanner(System.in);
                if (!(scanPassword.nextLine().length() <= 7)) { //ADD FUNCTION WHERE PASSWORDS ARE CHECKED AND CONFIRMED
                    System.out.println("Retype Password: ");
                    Scanner finalPasswordScan = new Scanner(System.in);
                    userPassword = finalPasswordScan.nextLine();
//                    System.out.println("userpassword = " + userPassword); DEBUGGING
                    break;
                } else {
                    System.out.println("Password is to weak... \n Are you sure you want to proceed (yes/no)");
                    Scanner scanYesNo = new Scanner(System.in);
                    if (scanYesNo.nextLine().toLowerCase().equals("yes")) {
                        break;
                    } else{
                        continue;
                    }
                }



            }
    }
}
