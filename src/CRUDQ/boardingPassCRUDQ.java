package CRUDQ;

import entity.BoardingPass_Entity;
import entity.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class boardingPassCRUDQ {
    static Scanner scanner = new Scanner(System.in);
    //create boarding pass [entity] method

    public static String getInput (String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public static void createBoardingPass() {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(BoardingPass_Entity.class)
                .buildSessionFactory();

        //create a session
        Session session = factory.getCurrentSession();

        try {
            //create passenger object(s)
            System.out.println("Creating passenger object(s)...");

            BoardingPass_Entity tempPass = new BoardingPass_Entity(
                    getInput("Enter name"),
                    getInput("Enter email"),
                    getInput("Enter phone number"),
                    getInput("Enter gender"),
                    Integer.parseInt(getInput("Enter age number")),
                    getInput("Enter flight date ('MM/DD/YYYY')"),
                    getInput("Enter origin location ('City, ST')"),
                    getInput("Enter destination location ('City, ST')"),
                    getInput("Enter expected time arrival ('HH:MM')"),
                    getInput("Enter departure time ('HH:MM')"),
                    getInput("Enter the ticket price"));

            //start a transaction
            session.beginTransaction();
            System.out.println("Beginning transaction...");

            //save the boarding pass object
            session.save(tempPass);
            System.out.println("Saving the new passenger(s)...");

            //commit the transaction
            session.getTransaction().commit();
            System.out.println(".. ... .... ..... \n Create Task Completed!");
            System.out.println();
        } catch (Exception e) {
            System.out.println("ID couldn't be found, enter another one!");
        }finally {
            factory.close();
        }
    }

    //read method
    public static void retrieveBoardingPass(){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(BoardingPass_Entity.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();

        try{
            //***********************************************************************************
            //***Code for Reading the object***
            //find out the passenger's id: primary key
            int boarding_passID = Integer.parseInt(getInput("Enter the boarding pass ID that you would like to see the details of"));

            //Get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Retrieve passenger based on the id: primary key
            System.out.println("\nGetting passenger with boarding pass id: " + boarding_passID);
            BoardingPass_Entity myPassenger = session.get(BoardingPass_Entity.class, boarding_passID);
            System.out.println("Retrieve successful: " + myPassenger);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println(".. ... .... \nRetrieve Task Completed!");
            System.out.println();
        } catch (Exception e) {
            System.out.println("ID couldn't be found, enter another one!");
        }finally {
            factory.close();
        }
    }

    //update method
    public static void updateBoardingPass() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(BoardingPass_Entity.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();

        try{
            int boarding_passID = Integer.parseInt(getInput("Enter the boarding pass ID you're looking to update"));
            //Get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Retrieve passenger based on the id: primary key
            System.out.println("\nGetting passenger with id: " + boarding_passID);
            BoardingPass_Entity myPassenger = session.get(BoardingPass_Entity.class, boarding_passID);

            //Updating the passenger first Name at primary key 1
            System.out.println("Updating BoardingPass_Entity...");
            System.out.println("1.) update name");
            System.out.println("2.) update email");
            System.out.println("3.) update phone number");
            System.out.println("4.) update date");
            System.out.println("5.) update origin");
            System.out.println("6.) update destination");
            System.out.println("7.) update ETA");
            System.out.println("8.) update departure time");
            System.out.println("9.) update ticket price");
            Scanner updateScan = new Scanner(System.in);
            String updateOption = updateScan.nextLine();


            if(updateOption.equals("1")) {
                myPassenger.setName(getInput("Enter the new name you'd like to update"));
                System.out.println("Updating name for the passenger(s)...");
            }
            else if (updateOption.equals("2")) {
                myPassenger.setEmail(getInput("Enter the new email you'd like to update"));
                System.out.println("Updating email for the passenger(s)...");
            }
            else if(updateOption.equals("3")) {
                myPassenger.setPhone_num(getInput("Enter the new phone number you'd like to update"));
                System.out.println("Updating phone number for the passenger(s)...");
            }
            else if(updateOption.equals("4")) {
                myPassenger.setDate(getInput("Enter the new date you'd like to update"));
                System.out.println("Updating date for the passenger(s)...");
            }
            else if(updateOption.equals("5")) {
                myPassenger.setOrigin(getInput("Enter the new origin location you'd like to update"));
                System.out.println("Updating origin location for the passenger(s)...");
            }
            else if(updateOption.equals("6")) {
                myPassenger.setDestination(getInput("Enter the new destination you'd like to update"));
                System.out.println("Updating destination location for the passenger(s)...");
            }
            else if(updateOption.equals("7")) {
                myPassenger.setETA(getInput("Enter the new estimated time arrival you'd like to update"));
                System.out.println("Updating estimated time arrival for the passenger(s)...");
            }
            else if(updateOption.equals("8")) {
                myPassenger.setDepartureTime(getInput("Enter the new departure time you'd like to update"));
                System.out.println("Updating departure time for the passenger(s)...");
            }
            else if(updateOption.equals("9")) {
                myPassenger.setTicketPrice(getInput("Enter the new ticket price you'd like to update"));
                System.out.println("Updating price for the passenger(s)...");
            }

            //commit the transaction
            session.getTransaction().commit();

            //*********************************************************//
            //Create new factory session to do a bulk update
            session = factory.getCurrentSession();
            session.beginTransaction();

            //commit the transaction
            session.getTransaction().commit();
            System.out.println(".. ... .... \nUpdate Task Completed!");
            System.out.println();
        }
            finally {
            factory.close();
        }
    }

    //delete passenger method
    public static void removeBoardingPass() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(BoardingPass_Entity.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();

        try{
            int boarding_passID = Integer.parseInt(getInput("Enter the boarding pass ID you're looking to delete")); //need to update this to take int scanner input rather than fixed ID [to avoid null value error exceptions]
            //Get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Retrieve passenger based on the id: primary key
            System.out.println("\nGetting passenger with boarding pass ID: " + boarding_passID);
            BoardingPass_Entity myPassenger = session.get(BoardingPass_Entity.class, boarding_passID);

            //Delete the passenger
            System.out.println("Deleting passenger: " + myPassenger);
            session.delete(myPassenger);

            //Delete passenger where id=15 this allows you to delete on the fly instead of having to retrieve the object.
            System.out.println("Deleting passenger where id=" + boarding_passID);
            session.createQuery("delete from BoardingPass_Entity where id=" + boarding_passID).executeUpdate();

            //commit the transaction
            session.getTransaction().commit();
            System.out.println(".. .... ....... Delete Task Completed!");
            System.out.println();
        } catch (Exception e) {
            System.out.println("ID couldn't be found, enter another one!");
        }finally {
            factory.close();
        }
    }
}
