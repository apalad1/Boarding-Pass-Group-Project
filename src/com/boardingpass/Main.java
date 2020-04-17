package com.boardingpass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
// Update 11
public class Main {
    public static void main(String[] args) {
        // Get Boarding Passes with data from the database

        String name = "Harry Potter";
        String email = "harrypotter@hogwarts.com";
        String phoneNumber = "(123)456-7890";
        String gender = "M";
        int age = 30;
        String destination = "FLL";
        String departureTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        BoardingPass hp = new BoardingPass(name, email, phoneNumber, gender, age, destination, departureTime);
        System.out.println(hp.toString());

        // Append the boarding passes to a file in a user-friendly format
    }
}