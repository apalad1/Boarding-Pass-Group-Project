import CRUDQ.*;
import entity.Passenger;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Welcome to AGS Airlines");
        boolean notDone = false;
//        System.out.println("1.) Create new boarding pass object from database");
//        System.out.println("2.) Delete boarding pass from database");
//        System.out.println("3.) Update a boarding pass based on ID");
//        System.out.println("4.) Read and display boarding pass from database based on ID");
//        System.out.println("5.) Exit program");
        //Passenger testPass = new Passenger("Mace", "Windu", "mace_windu@swEU.com", "777-888-7878", "05/22/2020", "San Antonio, TX", "Charlotte, NC", "17:05", "14:00");
        //CRUDQ.createPassenger();
        //CRUDQ.removePassenger();
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
                //boardingPassCRUDQ.createBoardingPass();
//            boardingPassCRUDQ.removeBoardingPass();
            }
        } catch (Exception except){
            System.out.println("Stop trying to break me code");
        }
    }
}
