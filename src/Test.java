import CRUDQ.boardingPassCRUDQ;

import java.util.Scanner;
// Update 10
//Administrative console to simply CRUDQ interactions with the database.
public class Test {
    public static void main(String[] args) {
        System.out.println("Welcome to AGS Airlines");

        try {

            while (true) {
                System.out.println("1.) Create new boarding pass object from database");
                System.out.println("2.) Delete boarding pass from database");
                System.out.println("3.) Update a boarding pass based on ID");
                System.out.println("4.) Read and display boarding pass from database based on ID");
                System.out.println("5.) Exit program");
                Scanner testScan = new Scanner(System.in);
                String userChoice = testScan.nextLine();

                if (userChoice.equals("1")) {
                    boardingPassCRUDQ.createBoardingPass();
                } else if (userChoice.equals("2")) {
                    boardingPassCRUDQ.removeBoardingPass();
                } else if (userChoice.equals("3")) {
                    boardingPassCRUDQ.updateBoardingPass();
                } else if (userChoice.equals("4")) {
                    boardingPassCRUDQ.retrieveBoardingPass();
                } else if (userChoice.equals("5")) {
                    break;
                }
                else{
                    System.out.println("Enter a valid number buddy");
                }
            }
        } catch (Exception except){
            System.out.println("Stop trying to break me code");
        }
    }
}
