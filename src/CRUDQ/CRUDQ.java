package CRUDQ;

import entity.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUDQ {
    //create passenger obj entity method
    //public static void createPassenger() {
    public static void createPassenger() {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Passenger.class)
                .buildSessionFactory();

        //create a session
        Session session = factory.getCurrentSession();

        try {
            //create passenger object(s)
            System.out.println("Creating passenger object(s)...");
            Passenger tempPassenger = new Passenger("Ellie", "Ingram", "ellie@code.com", "777-777-7777", "05/22/2020", "San Antonio, TX", "Charlotte, NC", "17:05", "14:00");
//            Passenger tempStudent1 = new Passenger("Laila", "Lindsay", "laila@code.com");
//            Passenger tempStudent2 = new Passenger("Jill", "Jack", "jill@code.com");

            //start a transaction
            session.beginTransaction();
            System.out.println("Beginning transaction...");

            //save the student object
            session.save(tempPassenger);
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
    public static void retrievePassenger(){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Passenger.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();

        try{
            //create a new passenger object
            //code needs modification; don't believe it's necessary to create new passenger object --> may also lead to later errors
            System.out.println("Creating new passenger object...");
            Passenger tempPassenger = new Passenger("Mace", "Windu", "mace_windu@swEU.com", "777-888-7878", "05/22/2020", "San Antonio, TX", "Charlotte, NC", "17:05", "14:00");

            //start a transaction
            session.beginTransaction();
            System.out.println("Beginning transaction...");

            //save the student object
            System.out.println("Saving the new passenger...");
            System.out.println(tempPassenger);
            session.save(tempPassenger);

            //commit the transaction
            session.getTransaction().commit();

            //***********************************************************************************
            //***Code for Reading the object***
            //find out the student's id: primary key
            System.out.println("Saved the passenger. Generated boarding pass id: " + tempPassenger.getId());

            //Get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Retrieve student based on the id: primary key
            System.out.println("\nGetting passenger with boarding pass id: " + tempPassenger.getId());
            Passenger myPassenger = session.get(Passenger.class, tempPassenger.getId());
            System.out.println("Get Completed: " + myPassenger);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    //update method
    public static void updatePassenger() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Passenger.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();

        try{
            int boarding_passID = 32;
            //Get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + boarding_passID);
            Passenger myPassenger = session.get(Passenger.class, boarding_passID);

            //Updating the student first Name at primary key 1
            System.out.println("Updating Passenger...");
            myPassenger.setFirstName("Jefe");

            //commit the transaction
            session.getTransaction().commit();

            //*********************************************************//
            //Create new factory session to do a bulk update
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Update email for all students
            System.out.println("Updating email for the passenger(s)...");
            session.createQuery("update Passenger set email='foo@gmail.com'").executeUpdate();
            //or you can use a where clause to be more precise
            session.createQuery("update Passenger set email='too@gmail.com' where email='foo@gmail.com'").executeUpdate();

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }


    }

    //delete passenger method
    public static void removePassenger() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Passenger.class)
                .buildSessionFactory();

        //create a session this is for hibernate
        Session session = factory.getCurrentSession();

        try{
            int boarding_passID = 1; //need to update this to take int scanner input rather than fixed ID [to avoid null value error exceptions]
            //Get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Retrieve passenger based on the id: primary key
            System.out.println("\nGetting passenger with boarding pass ID: " + boarding_passID);
            Passenger myPassenger = session.get(Passenger.class, boarding_passID);

            //Delete the passenger
            System.out.println("Deleting passenger: " + myPassenger);
            session.delete(myPassenger);

            //Delete passenger where id=15 this allows you to delete on the fly instead of having to retrieve the object.
            System.out.println("Deleting passenger where id=" + boarding_passID);
            session.createQuery("delete from Passenger where id=" + boarding_passID).executeUpdate();

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }

    }

}
