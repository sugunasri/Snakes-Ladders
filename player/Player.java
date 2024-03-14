package player;

import java.util.*;

public class Player {

    private String name;
    private int age;
    private String phno;
    private String mailID;
    private String city;

    Scanner scn = new Scanner(System.in);

    //Getter and setters for members
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }
    public String getMailID() {
        return mailID;
    }

    public void setMailID(String mailID) {
        this.mailID = mailID;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    private void filldetails(){
        System.out.print("Enter the player's name: ");
        this.name = scn.nextLine();
        System.out.print("Enter your age: ");
        this.age = scn.nextInt();
        scn.nextLine();
        System.out.print("Enter your contact number: ");
        this.phno = scn.nextLine();
        System.out.print("Enter your mail ID: ");
        this.mailID = scn.nextLine();
        System.out.print("Enter your city name: ");
        this.city = scn.nextLine();
        System.out.println();
    }


    public Player(String name,int age,String pho,String mail,String city){
        this.name = name;
        this.age = age;
        this.phno = pho;
        this.mailID = mail;
        this.city = city;
    }

    public Player(){
        filldetails();
    }
    public void getdetails(){
        System.out.println("Player's details: ");
        System.out.println("Name: "+this.name);
        System.out.println("Age: "+this.age);
        System.out.println("contact number: "+this.phno);
        System.out.println("Mail Id: "+this.mailID);
        System.out.println("City: "+this.city);
    }
}
