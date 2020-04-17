package com.boardingpass;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
// Update 10
public class BoardingPass {
    private int age, boardingPassNumber;
    private String name, email, phoneNumber, gender, origin, destination, departureTime, estimatedArrivalTime, strDate;
    private String ticketPrice;

    public BoardingPass(String name, String email, String phoneNumber, String gender, int age,
                        String destination, String departureTime){
        this.boardingPassNumber = ((int)(Math.random()*9999999));
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.origin = "ATL";
        this.destination = destination;
        this.departureTime = departureTime;
        this.ticketPrice = setPriceWithAgeAndGender(this.age);
        // pattern "MM/dd/yyyy HH:mm:ss"
        Calendar cal = Calendar.getInstance();
        this.strDate = new SimpleDateFormat("MM/dd/yyyy").format(cal.getTime());
        cal.add(Calendar.HOUR_OF_DAY,1);
        this.estimatedArrivalTime = new SimpleDateFormat("HH:mm:ss").format(cal.getTime());
    }

    public int getBoardingPassNumber() {
        return boardingPassNumber;
    }

    public void setBoardingPassNumber(int boardingPassNumber){
        this.boardingPassNumber = boardingPassNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOrigin(){
        return origin;
    }

    public void setOrigin(String origin){
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String setPriceWithAgeAndGender(int theAge){
        double price = 100.0;
        if(theAge <= 12)
            price *= 0.5;
        else if(theAge >= 60){
            String getGender = gender.toLowerCase();
            price *= 0.4;
            if(getGender.equals("f"))
                price *= 0.75;
        }
        return NumberFormat.getCurrencyInstance(Locale.US).format(price);
    }
    public String toString(){
        return  "BOARDING PASS INFORMATION\n" +
                "Boarding Pass Number: " + boardingPassNumber + "\n" +
                "Date: " + strDate + "\n" +
                "Origin: " + origin + "\n" +
                "Destination: " + destination + "\n" +
                "Departure Time: " + departureTime + "\n" +
                "Estimated Arrival Time: " + estimatedArrivalTime + "\n\n" +
                "PASSENGER INFORMATION\n" +
                "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Gender: " + gender + "\n" +
                "Age: " + age + "\n\n" +
                "Total Ticket Price: " + ticketPrice;
    }
}