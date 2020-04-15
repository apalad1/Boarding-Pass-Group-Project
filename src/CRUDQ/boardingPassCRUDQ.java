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
    //create passenger obj entity method
    //public static void createPassenger() {

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
//            BoardingPass_Entity tempPass = new BoardingPass_Entity("test testington", "test@gmail.com", "777-777-7777", "m", 92, "11/11/2020", "Tst, MT", "Test, NC", "15:00", "12:00", "$400.00");
////            BoardingPass_Entity tempPassenger = new BoardingPass_Entity("Ellie", "Ingram", "ellie@code.com", "777-777-7777", "05/22/2020", "San Antonio, TX", "Charlotte, NC", "17:05", "14:00");
            BoardingPass_Entity tempPass = new BoardingPass_Entity(
                    getInput("Enter name"),
                    getInput("Enter email"),
                    getInput("Enter phone number"),
                    getInput("Enter gender"),
                    Integer.parseInt(getInput("Enter age number")),
                    //22,
                    getInput("Enter flight date"),
                    getInput("Enter origin location ('City, ST')"),
                    getInput("Enter destination location ('City, ST')"),
                    getInput("Enter expected time arrival ('HH:MM')"),
                    getInput("Enter departure time ('HH:MM')"),
                    getInput("Enter the ticket price"));
                    //new BoardingPass_Entity().setPriceWithAgeAndGender(Integer.parseInt(getInput("What was the age?"))));
                    //new BoardingPass_Entity().getTicketPrice());
                    //"$200.00");
                    //getInput("Enter price"));
                    //getInput("Ticket price"));
//            BoardingPass_Entity tempStudent1 = new BoardingPass_Entity("Laila", "Lindsay", "laila@code.com");
//            BoardingPass_Entity tempStudent2 = new BoardingPass_Entity("Jill", "Jack", "jill@code.com");

            //start a transaction
            session.beginTransaction();
            System.out.println("Beginning transaction...");

            //save the passenger object
            session.save(tempPass);
//            session.save(tempStudent1);
//            session.save(tempStudent2);
            System.out.println("Saving the new passenger(s)...");

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
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
            //create a new passenger object
            //code needs modification; don't believe it's necessary to create new passenger object --> may also lead to later errors
            System.out.println("Creating new passenger object...");
            BoardingPass_Entity tempPass = new BoardingPass_Entity("Mace Windu", "mace_windu@swEU.com", "777-888-7878", " Male", 27, "05/22/2020", "San Antonio, TX", "Charlotte, NC", "17:05", "14:00", "$200");

            //start a transaction
            session.beginTransaction();
            System.out.println("Beginning transaction...");

            //save the passenger object
            System.out.println("Saving the new passenger...");
            System.out.println(tempPass);
            session.save(tempPass);

            //commit the transaction
            session.getTransaction().commit();

            //***********************************************************************************
            //***Code for Reading the object***
            //find out the passenger's id: primary key
            System.out.println("Saved the passenger. Generated boarding pass id: " + tempPass.getId());

            System.out.println("Saved the passenger. Generated boarding pass id: " + tempPass.getId());

            //Get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Retrieve passenger based on the id: primary key
            System.out.println("\nGetting passenger with boarding pass id: " + tempPass.getId());
            BoardingPass_Entity myPassenger = session.get(BoardingPass_Entity.class, tempPass.getId());
            System.out.println("Get Completed: " + myPassenger);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
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

            String updateStr = "";

            if(updateOption.equals("1")) {
                //myPassenger.setName(getInput("Enter the new name you'd like to update"));
                System.out.println("Updating name for the passenger(s)...");
                session.createQuery("update BoardingPass_Entity set name=" + myPassenger.getName() + " " +  "where name=" + myPassenger.getName()).executeUpdate();
            }
            else if (updateOption.equals("2")) {
                myPassenger.setEmail(getInput("Enter the new email you'd like to update"));
                System.out.println("Updating email for the passenger(s)...");
                session.createQuery("update BoardingPass_Entity set email='too@gmail.com' where email=" + myPassenger.getEmail()).executeUpdate();
            }
            else if(updateOption.equals("3")) {
                myPassenger.setPhone_num(getInput("Enter the new phone number you'd like to update"));
                System.out.println("Updating phone number for the passenger(s)...");
                session.createQuery("update BoardingPass_Entity set phone_num='too@gmail.com' where email=" + myPassenger.getPhone_num()).executeUpdate();
            }
            else if(updateOption.equals("4")) {
                myPassenger.setDate(getInput("Enter the new date you'd like to update"));
                System.out.println("Updating date for the passenger(s)...");
                session.createQuery("update BoardingPass_Entity set date='too@gmail.com' where email=" + myPassenger.getDate()).executeUpdate();
            }
            else if(updateOption.equals("5")) {
                myPassenger.setOrigin(getInput("Enter the new origin location you'd like to update"));
                System.out.println("Updating origin location for the passenger(s)...");
                session.createQuery("update BoardingPass_Entity set origin='too@gmail.com' where email=" + myPassenger.getOrigin()).executeUpdate();
            }
            else if(updateOption.equals("6")) {
                myPassenger.setDestination(getInput("Enter the new destination you'd like to update"));
                System.out.println("Updating destination location for the passenger(s)...");
                session.createQuery("update BoardingPass_Entity set destination='too@gmail.com' where email=" + myPassenger.getDestination()).executeUpdate();
            }
            else if(updateOption.equals("7")) {
                myPassenger.setETA(getInput("Enter the new estimated time arrival you'd like to update"));
                System.out.println("Updating estimated time arrival for the passenger(s)...");
                session.createQuery("update BoardingPass_Entity set ETA='too@gmail.com' where email=" + myPassenger.getETA()).executeUpdate();
            }
            else if(updateOption.equals("8")) {
                myPassenger.setDepartureTime(getInput("Enter the new departure time you'd like to update"));
                System.out.println("Updating departure time for the passenger(s)...");
                session.createQuery("update BoardingPass_Entity set departure_time='too@gmail.com' where email=" + myPassenger.getDepartureTime()).executeUpdate();
            }
            else if(updateOption.equals("9")) {
                myPassenger.setTicketPrice(getInput("Enter the new ticket price you'd like to update"));
                System.out.println("Updating price for the passenger(s)...");
                session.createQuery("update BoardingPass_Entity set ticket_price='too@gmail.com' where email=" + myPassenger.getTicketPrice()).executeUpdate();
            }

            //commit the transaction
            session.getTransaction().commit();

            //*********************************************************//
            //Create new factory session to do a bulk update
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Update email for all students
            //System.out.println("Updating email for the passenger(s)...");
//            session.createQuery("update BoardingPass_Entity set email='foo@gmail.com'").executeUpdate();
//            //or you can use a where clause to be more precise
//            session.createQuery("update BoardingPass_Entity set email='too@gmail.com' where email='foo@gmail.com'").executeUpdate();

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
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
            System.out.println("Done!");
        } finally {
            factory.close();
        }

    }

}
