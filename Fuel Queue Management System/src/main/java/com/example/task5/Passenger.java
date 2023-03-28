package com.example.task5;
import java.util.Scanner;
public class Passenger {
    private String FirstName;
    private String SecondName;
    private int Vehiclenum;
    private int num_litres;

    public String getFirstName() {
        return FirstName;
    }
    public String getSecondName() {
        return SecondName;
    }
    public int getVehiclenum() {
        return Vehiclenum;
    }
    public int getNum_litres() {
        return num_litres;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public void setVehiclenum(int vehiclenum) {
        Vehiclenum = vehiclenum;
    }

    public void setNum_litres(int num_litres) {
        this.num_litres = num_litres;
    }

    public void AddCustomer(){
        Scanner input = new Scanner(System.in);
        System.out.println("First name of the customer");
        FirstName = input.nextLine();
        System.out.println("Second name of the customer");
        SecondName = input.nextLine();
        System.out.println("Vehicle number of the customer");
        while(!input.hasNextInt()) {
            System.out.println("Please enter a valid number");
            input.next();
        }
        Vehiclenum = input.nextInt();
        System.out.println("Number of litres the customer needs");
        while(!input.hasNextInt()) {
            System.out.println("Please enter a valid number");
            input.next();
        }
        num_litres=input.nextInt();
    }
    public void initialize(){
        FirstName="Empty";
        SecondName="Empty";
        Vehiclenum=0;
        num_litres=0;
    }
}