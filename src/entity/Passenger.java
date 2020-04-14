package entity;

import javax.persistence.*;
import java.util.Date;

//Student Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "hb_pass_tracker") //This is for the actual name of the database table name we are mapping to the class.
public class Passenger {

    //Database Mapping
    @Id //This will map the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This is used with auto increment for your primary key.
    @Column(name = "id") //This is mapping the primary key to the id column in your database. Should be the BOARDING PASS NUMBER in the database table.
    private int id;

    @Column(name = "first_name") //This will map the firstName field to the column named first_name in your student table.
    private String firstName;

    @Column(name = "last_name") //This will map the lastName field to the column named last_name in your student table.
    private String lastName;

    @Column(name = "email") //This will map the email field to the column named email in your student table.
    private  String email;

    @Column(name = "phone_num") //This will map the phoneNum field to the column named phone_num in your student table.
    private  String phoneNum;

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

    //Constructors
    public Passenger() {

    }

    public Passenger(String firstName, String lastName, String email, String phoneNum, String date, String origin, String destination, String ETA, String departureTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.ETA = ETA;
        this.departureTime = departureTime;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_num() {
        return phoneNum;
    }
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

    public String getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    //To string method
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +

                ", phone number='" + phoneNum + '\'' +
                ", date='" + date + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", ETA='" + ETA + '\'' +
                ", departureTime='" + departureTime + '\'' +
                '}';
    }
}
