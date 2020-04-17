package entity;

import com.boardingpass.BoardingPass;

import javax.persistence.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
// Update 9
//BoardingPass Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "boarding_pass_tracker") //This is for the actual name of the database table name we are mapping to the class.
public class BoardingPass_Entity {

    //Database Mapping
    @Id //This will map the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This is used with auto increment for your primary key.
    @Column(name = "id") //This is mapping the primary key to the id column in your database. Should be the BOARDING PASS NUMBER in the database table.
    private int id;

    @Column(name = "name") //This will map the firstName field to the column named first_name in your student table.
    private String name;

    @Column(name = "email") //This will map the email field to the column named email in your student table.
    private  String email;

    @Column(name = "phone_num") //This will map the phoneNum field to the column named phone_num in your student table.
    private  String phoneNum;

    @Column(name = "gender") //This will map the date field to the column named date in your student table.
    private String gender;

    @Column(name = "age") //This will map the date field to the column named date in your student table.
    private int age;

    @Column(name = "date") //This will map the date field to the column named date in your student table.
    private String date;

    @Column(name = "origin") //This will map the origin field to the column named origin in your student table.
    private  String origin;

    @Column(name = "destination") //This will map the destination field to the column named destination in your student table.
    private  String destination;

    @Column(name = "ETA") //This will map the ETA field to the column named ETA in your student table.
    private  String ETA;

    @Column(name = "departure_time") //This will map the departureTime field to the column named departure_time in your student table.
    private  String departureTime;

    @Column(name = "ticket_price") //This will map the departureTime field to the column named departure_time in your student table.
    private  String ticketPrice;

    //note** could not find a place to implement the "setPriceWithAge" method into the code
    // all entries are String input that rely on the admin user to input accurate, formatted, and/or valid data entries
    //Constructor(s) below:
    public BoardingPass_Entity(String name, String email, String phoneNum, String gender, int age, String date, String origin, String destination, String ETA, String departureTime, String ticketPrice) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.gender = gender;
        this.age = age;
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.ETA = ETA;
        this.departureTime = departureTime;
        this.ticketPrice = ticketPrice;
    }

    // all entries are String input except age that rely on the admin user to input accurate, formatted, and/or valid data entries
    // Overloaded Constructor(s) below:
    public BoardingPass_Entity(BoardingPass newPerson) {
        //this.id = newPerson.getBoardingPassNumber(); does not get displayed because sql cannot retrieve the id
        this.name = newPerson.getName();
        this.email = newPerson.getEmail();
        this.phoneNum = newPerson.getPhoneNumber();
        this.gender = newPerson.getGender();
        this.age = newPerson.getAge();
        this.origin = newPerson.getOrigin();
        this.destination = newPerson.getDestination();
        this.ticketPrice = setPriceWithAgeAndGender(this.age);
        // pattern "MM/dd/yyyy HH:mm:ss"
        Calendar cal = Calendar.getInstance();
        this.departureTime = new SimpleDateFormat("HH:mm:ss").format(cal.getTime());
        this.date = new SimpleDateFormat("MM/dd/yyyy").format(cal.getTime());
        cal.add(Calendar.HOUR_OF_DAY,1);
        this.ETA = new SimpleDateFormat("HH:mm:ss").format(cal.getTime());
    }

    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_num() { return phoneNum; }
    public void setPhone_num(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getETA() {
        return ETA;
    }
    public void setETA(String ETA) {
        this.ETA = ETA;
    }

    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getTicketPrice() { return ticketPrice; }
    public void setTicketPrice(String ticketPrice){
        this.ticketPrice = ticketPrice;
    }

    public String setPriceWithAgeAndGender(int theAge) {
        double price = 100.0;
        if (theAge <= 12)
            price *= 0.5;
        else if (theAge >= 60) {
            String getGender = gender.toLowerCase();
            price *= 0.4;
            if (getGender.equals("f"))
                price *= 0.75;
        }
        return NumberFormat.getCurrencyInstance(Locale.US).format(price);
    }


    //To string method
    @Override
    public String toString() {
        return "Boarding Pass Details{" +
                "\nBoarding Pass Number: " + id +
                ", \nName: '" + name+ '\'' +
                ", \nEmail: '" + email + '\'' +
                ", \nPhone Number: " + phoneNum + '\'' +
                ", \nGender: '" + gender + '\'' +
                ", \nAge: '" + age + '\'' +
                ", \nDate: '" + date + '\'' +
                ", \nOrigin: '" + origin + '\'' +
                ", \nDestination: '" + destination + '\'' +
                ", \nETA: '" + ETA + '\'' +
                ", \nDeparture Time: '" + departureTime + '\'' +
                ", \nTicket Price: '" + ticketPrice + '\'' +
                '}';
    }
}
