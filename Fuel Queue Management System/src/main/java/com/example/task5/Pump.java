package com.example.task5;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pump {
    public static FuelQueue queue1=new FuelQueue();
    public static FuelQueue queue2=new FuelQueue();
    public static FuelQueue queue3=new FuelQueue();
    public static FuelQueue queue4=new FuelQueue();
    public static FuelQueue queue5=new FuelQueue();
    public static FuelQueue WaitingQueue=new FuelQueue(6);
    public static String show(int queue,int n){
        if (queue==1) {
            return queue1.show(n);
        }
        else if (queue==2){
            return queue2.show(n);
        }
        else if (queue==3){
            return queue3.show(n);
        }else if (queue==4){
            return queue4.show(n);
        }else if (queue==5){
            return queue5.show(n);
        }
        else{
            return "1";
        }
    }
    public static void ViewQueues(){
        System.out.println("Queue 1");
        queue1.DisplayCustomer();
        System.out.println("Queue 2");
        queue2.DisplayCustomer();
        System.out.println("Queue 3");
        queue3.DisplayCustomer();
        System.out.println("Queue 4");
        queue4.DisplayCustomer();
        System.out.println("Queue 5");
        queue5.DisplayCustomer();
        System.out.println("Waiting Queue");
        WaitingQueue.DisplayCustomer();
    }
    //Method to view empty queues
    public static void ViewEmptyQueues(){
        for (int index=0;index<6;index++) {
            if (queue1.empqueues().equals("empty")) {
                System.out.println("Queue 1");
                queue1.DisplayCustomer();
                break;
            }
        }
        for (int index=0;index<6;index++) {
            if (queue2.empqueues().equals("empty")) {
                System.out.println("Queue 2");
                queue2.DisplayCustomer();
                break;
            }
        }
        for (int index=0;index<6;index++) {
            if (queue3.empqueues().equals("empty")) {
                System.out.println("Queue 3");
                queue3.DisplayCustomer();
                break;
            }
        }
        for (int index=0;index<6;index++) {
            if (queue4.empqueues().equals("empty")) {
                System.out.println("Queue 4");
                queue4.DisplayCustomer();
                break;
            }
        }
        for (int index=0;index<6;index++) {
            if (queue5.empqueues().equals("empty")){
                System.out.println("Queue 5");
                queue5.DisplayCustomer();
                break;
            }
        }
    }
    //Method to add customer and to the minimum queue length
    public static void AddCustomer(){
        for (int c=0;c<6;c++){
            if (queue1.addcustomer(c).equals("done")){
                break;
            }
            else if (queue2.addcustomer(c).equals("done")){
                break;
            }
            else if (queue3.addcustomer(c).equals("done")){
                break;
            }
            else if (queue4.addcustomer(c).equals("done")){
                break;
            }
            else if (queue5.addcustomer(c).equals("done")){
                break;
            }
            else if (c==5){
                WaitingQueue.AddWaitingQueue(4);
                break;
            }
        }
    }
    //Method to add customer from waiting queue to the fuel queue
    public static void MoveWaiting(int queuenum){
        //to check if the waiting queue is empty
        if (WaitingQueue.AddWaitingQueue(1)!=-1){
            String [] arr=WaitingQueue.CustomerTransfer();
            if (queuenum==1){
                queue1.FromWaiting(arr[0],arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));
            }
            else if (queuenum==2){
                queue2.FromWaiting(arr[0],arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));
            }
            else if (queuenum==3){
                queue3.FromWaiting(arr[0],arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));
            }
            else if (queuenum==4){
                queue4.FromWaiting(arr[0],arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));
            }
            else if (queuenum==5){
                queue5.FromWaiting(arr[0],arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));
            }
        }
    }
    //Method to remove served customer
    public static void RemoveCustomer(){
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter the queue number:" );
        while(!input.hasNextInt()) {
            System.out.println("Please enter a valid queue number");
            input.next();
        }
        int queuenum=input.nextInt();
        if (queuenum==1){
            queue1.RemoveServed();
            MoveWaiting(queuenum);
        }
        else if (queuenum==2){
            queue2.RemoveServed();
            MoveWaiting(queuenum);
        }
        else if (queuenum==3){
            queue3.RemoveServed();
            MoveWaiting(queuenum);
        }
        else if (queuenum==4){
            queue4.RemoveServed();
            MoveWaiting(queuenum);
        }
        else if (queuenum==5){
            queue5.RemoveServed();
            MoveWaiting(queuenum);
        }
    }
    //Method to remove customer from a queue in a specific position
    public static void removepos() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the queue number");
        while(!input.hasNextInt()) {
            System.out.println("Please enter a valid queue number");
            input.next();
        }
        int queuenum = input.nextInt();
        System.out.println("position");
        while(!input.hasNextInt()) {
            System.out.println("Please enter a valid number");
            input.next();
        }
        int position = input.nextInt();
        if (queuenum == 1) {
            queue1.RemoveIndex(position-1);
            MoveWaiting(queuenum);
        } else if (queuenum == 2) {
            queue2.RemoveIndex(position-1);
            MoveWaiting(queuenum);
        } else if (queuenum == 3) {
            queue3.RemoveIndex(position-1);
            MoveWaiting(queuenum);
        } else if (queuenum == 4) {
            queue4.RemoveIndex(position-1);
            MoveWaiting(queuenum);
        } else if (queuenum == 5) {
            queue5.RemoveIndex(position-1);
            MoveWaiting(queuenum);
        }
    }
    //Method to sort and display the customers in the alphabetical order from a queue
    public static void AlphabetSorting(){
        System.out.println("Queue 1");
        queue1.alphabetsorting();
        System.out.println("Queue 2");
        queue2.alphabetsorting();
        System.out.println("Queue 3");
        queue3.alphabetsorting();
        System.out.println("Queue 4");
        queue4.alphabetsorting();
        System.out.println("Queue 5");
        queue5.alphabetsorting();
    }
    //Method to add fuel
    public static void AddFuel(){
        Scanner input=new Scanner(System.in);
        System.out.println("Number of litres ");
        while(!input.hasNextInt()) {
            System.out.println("Please enter a valid number");
            input.next();
        }
        int extrafuel=input.nextInt();
        FuelQueue.setFuelStock(FuelQueue.getFuelStock()+extrafuel);
        System.out.println("Successfully added fuel");
    }
    //method to store customers,waitinglist and fuelstock to the file
    public static void storefile(){
        try {
            FileWriter myWriter= new FileWriter("ProgramData.txt");
            myWriter.write(FuelQueue.getFuelStock()+"\r");
            for (int c=0;c<6;c++) {
                myWriter.write(queue1.details(c)+"\r");
            }
            myWriter.write(""+"\r");
            for (int c=0;c<6;c++) {
                myWriter.write(queue2.details(c)+"\r");
            }
            myWriter.write(""+"\r");
            for (int c=0;c<6;c++) {
                myWriter.write(queue3.details(c)+"\r");
            }
            myWriter.write(""+"\r");
            for (int c=0;c<6;c++) {
                myWriter.write(queue4.details(c)+"\r");
            }
            myWriter.write(""+"\r");
            for (int c=0;c<6;c++) {
                myWriter.write(queue5.details(c)+"\r");
            }
            myWriter.write(""+"\r");
            for (int c=0;c<6;c++) {
                myWriter.write(WaitingQueue.details(c)+"\r");
            }
            myWriter.write(""+"\r");
            myWriter.write(FuelQueue.getFront()+"\r");
            myWriter.write(FuelQueue.getRear()+"\r");
            System.out.println("Successfully wrote to the file.");
            myWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
        }
    }
    //Method to read file and store everything back
    public static void readfile(){
        int line=1;
        int index=0;
        try {
            File inputfile = new File("ProgramData.txt");
            Scanner rf = new Scanner(inputfile);
            String fileline;
            while (rf.hasNext()) {
                fileline = rf.nextLine();
                if (line==1){
                    FuelQueue.setFuelStock(Integer.parseInt(fileline));
                }
                else if(line>1 && line<8){
                    String[] details=fileline.split(",",4);
                    queue1.addfromfile(details,index);
                    index++;
                }
                else if(line>8 && line<15){
                    String[] details=fileline.split(",",4);
                    queue2.addfromfile(details,index);
                    index++;
                }
                else if(line>15 && line<22){
                    String[]details=fileline.split(",",4);
                    queue3.addfromfile(details,index);
                    index++;
                }
                else if(line>22 && line<29){
                    String[]details=fileline.split(",",4);
                    queue4.addfromfile(details,index);
                    index++;
                }
                else if(line>29 && line<36){
                    String[]details=fileline.split(",",4);
                    queue5.addfromfile(details,index);
                    index++;
                }
                else if(line>36 && line<43){
                    String[]details=fileline.split(",",4);
                    WaitingQueue.addfromfile(details,index);
                    index++;
                }
                else if(line==44){
                    FuelQueue.setFront(Integer.parseInt(fileline));
                }
                else if(line==45){
                    FuelQueue.setRear(Integer.parseInt(fileline));
                }
                line++;
                if (index==6){
                    index=0;
                }
            }
            rf.close();
            System.out.println("Loaded data into the file");
        }
        catch (IOException e)
        {
            System.out.println("Error IO exception is: "+ e);
        }
    }
    //Method to display the income of the queue
    public static void QueueIncome() {
        System.out.println("Income of each Fuel Queue");
        System.out.println("Queue 1 - "+queue1.getIncome());
        System.out.println("Queue 2 - "+queue2.getIncome());
        System.out.println("Queue 3 - "+queue3.getIncome());
        System.out.println("Queue 4 - "+queue4.getIncome());
        System.out.println("Queue 5 - "+queue5.getIncome());
    }
    public static void menu() {
        System.out.println("""
                100 or VFQ: View all Fuel Queues.
                101 or VEQ: View all Empty Queues.
                102 or ACQ: Add customer to a Queue.
                103 or RCQ: Remove a customer from a Queue. (From a specific location)
                104 or PCQ: Remove a served customer.
                105 or VCS: View Customers Sorted in alphabetical order
                106 or SPD: Store Program Data into file.
                107 or LPD: Load Program Data from file.
                108 or STK: View Remaining Fuel Stock.
                109 or AFS: Add Fuel Stock.
                110 or IFQ: Income of each fuel queue.
                999 or EXT: Exit the Program.""");
    }
    public static void options(String choice){
        switch (choice) {
            case "100":
            case "VFQ":
                ViewQueues();
                break;
            case "101":
            case "VEQ":
                ViewEmptyQueues();
                break;
            case "102":
            case "ACQ":
                AddCustomer();
                break;
            case "103":
            case "RCQ":
                removepos();
                break;
            case "104":
            case "PCQ":
                RemoveCustomer();
                break;
            case "105":
            case "VCS":
                AlphabetSorting();
                break;
            case "106":
            case "SPD":
                storefile();
                break;
            case "107":
            case "LPD":
                readfile();
                break;
            case "108":
            case "STK":
                System.out.println("Fuel left="+ FuelQueue.getFuelStock());
                break;
            case "109":
            case "AFS":
                AddFuel();
                break;
            case "110":
            case "IFQ":
                QueueIncome();
                break;
            case "999":
            case "EXT":
                System.out.println("The program is going to end");
                break;
        }
    }


    public static void main(String[]args){
        String choice;
        choice="5";
        while (!choice.equals("999")){
            menu();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the option");
            choice = input.nextLine();
            options(choice);
        }
    }
}
