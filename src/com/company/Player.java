package com.company;

import java.util.Scanner;

public class Player {
    //firstname, lastname, age, team(første eller andet hold).
    private String firstname;
    private String lastname;
    private int age;
    private int team;
    Scanner scanner = new Scanner(System.in);
    UserInput userInput = new UserInput();
    Player(){

    }
    Player(String firstname, String lastname, int age, int team){
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.team = team;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTeam(int team) {
        this.team = team;
    }



    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public int getTeam() {
        return team;
    }
    public void createPlayer(){
        String firstname = userInput.inputString("Input first name",true);
        String lastname = userInput.inputString("Input last name",true);
        int age = userInput.inputInt("Input age");
        int team = userInput.inputInt(1,2, "Input team");
        Player player = new Player(firstname, lastname, age, team);


}

    @Override
    public String toString() {
        return "Player{" + "firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' + ", age=" + age + ", team=" + team + '}';
    }
}
