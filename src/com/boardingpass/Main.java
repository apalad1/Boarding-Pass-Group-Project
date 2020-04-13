package com.boardingpass;

public class Main {

    public static void main(String[] args) {
        String name = "Harry Potter";
        String email = "harrypotter@hogwarts.com";
        String phoneNumber = "(123)456-7890";
        String gender = "M";
        int age = 30;
        String destination = "FLL";
        String departureTime = "21:00:00";
        BoardingPass hp = new BoardingPass(name, email, phoneNumber, gender, age, destination, departureTime);
        System.out.println(hp.toString());
    }
}