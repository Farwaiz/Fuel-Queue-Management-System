package com.example.task5;
public class FuelQueue {
    private Passenger[] queues;
    private static int FuelStock=6600;
    private int Income=0;
    private static int front=0;
    private static int rear=0;
    private int counter=0;

    public FuelQueue(){
        queues=new Passenger[6];
        for(int c=0;c<6;c++){
            queues[c]=new Passenger();
            queues[c].initialize();
        }
    }
    public FuelQueue(int number){
        queues=new Passenger[number];
        for (int c=0;c<number;c++){
            queues[c]=new Passenger();
            queues[c].initialize();
        }
    }
    public String show(int n){
        String firstname=queues[n].getFirstName();
        String secondname=queues[n].getSecondName();
        int vehiclenumber=queues[n].getVehiclenum();
        int litres=queues[n].getNum_litres();
        String name=(firstname + "," + secondname + "," + vehiclenumber + "," + litres);
        return name;
    }
    public static int getFuelStock() {
        return FuelStock;
    }
    public int getIncome() {
        return Income;
    }
    public static int getFront() {
        return front;
    }
    public static int getRear() {
        return rear;
    }

    public static void setFuelStock(int fuelStock) {
        FuelStock = fuelStock;
    }
    public static void setFront(int Front) {
        front=Front;
    }
    public static void setRear(int Rear) {
        rear = Rear;
    }

    public String addcustomer(int index){
        String name=queues[index].getFirstName();
        if (name.equals("Empty")){
            queues[index].AddCustomer();
            System.out.println("Added to the queue successfully");
            return "done";
        }
        else {
            return "spot full";
        }
    }
    //Method to check if the queue is full and to add customers
    public int AddWaitingQueue(int n){
        if (rear==front && !(queues[front].getFirstName()).equalsIgnoreCase("empty")){
            System.out.println("Queue is Full");
            return 1;
        }
        //To check if it is empty and if its empty it wont move anythng from waiting to fuel
        else if (n==1 && (queues[front].getFirstName()).equalsIgnoreCase("empty")){
            return -1;
        }
        else if (n==1 && (queues[rear].getFirstName()).equalsIgnoreCase("empty")){
            return 1;
        }
        else {
            queues[rear].AddCustomer();
            rear=(rear+1)%6;
            System.out.println("Item added to the waiting queue");
            return -1;
        }
    }
    //Method to take the first customer in the waiting queue to transfer to Fuel queue
    public String[] CustomerTransfer(){
        String[] Array = new String[4];
        Array[0] = queues[front].getFirstName();
        Array[1] = queues[front].getSecondName();
        Array[2] = String.valueOf(queues[front].getVehiclenum());
        Array[3] = String.valueOf(queues[front].getNum_litres());
        queues[front].initialize();
        front = (front + 1) % 6;
        return Array;
    }
    //Method to save the customer from waiting queue to the fuel queue
    public void FromWaiting(String first,String second,int vehiclenum,int litre){
        queues[5].setFirstName(first);
        queues[5].setSecondName(second);
        queues[5].setNum_litres(litre);
        queues[5].setVehiclenum(vehiclenum);
        sorting();
    }
    public void DisplayCustomer(){                          //Method to display all the customers of the specific queue
        for (int c=0;c<6;c++) {
            String firstname=queues[c].getFirstName();
            String secondname=queues[c].getSecondName();
            int vehiclenumber=queues[c].getVehiclenum();
            int litres=queues[c].getNum_litres();
            System.out.println(firstname + "," + secondname + "," + vehiclenumber + "," + litres);
        }
        System.out.println("");
    }
    public String empqueues(){          //Method to check if the specific queue is empty
        for (int c=0;c<6;c++){
            String name=queues[c].getFirstName();
            if (name.equalsIgnoreCase("empty")){
                return "empty";
            }
        }
        return "full";
    }
    //Method to remove the served customer of queue, decrease the number of litres served and calcualate the income
    public void RemoveServed(){
        FuelStock=FuelStock-queues[0].getNum_litres();
        queues[0].setFirstName("null");
        Income=Income+(queues[0].getNum_litres()*430);
        if (FuelStock<=500){
            System.out.println("WARNING!! THERE IS ONLY 500 LITRES OF FUEL LEFT");
        }
        sorting();
    }
    //Method to sort queue after removing a customer
    public void sorting(){
        for (int index=0;index<5;index++) {
            String name = queues[index].getFirstName();
            if (name.equals("null")) {
                queues[index].setFirstName(queues[index + 1].getFirstName());
                queues[index].setSecondName(queues[index + 1].getSecondName());
                queues[index].setVehiclenum(queues[index + 1].getVehiclenum());
                queues[index].setNum_litres(queues[index + 1].getNum_litres());
                queues[index + 1].setFirstName("null");
                if (index == 4) {
                    queues[5].initialize();
                }
            }
        }
        if (counter<=4){
            counter--;
        }
    }
    //Method to Display the customers of the specific queue in alphabetical order
    public void alphabetsorting() {
        String[] order = new String[6];
        for (int c = 0; c < 6; c++) {
            String name = queues[c].getFirstName() + " " +queues[c].getSecondName();
            order[c] = name;
        }
        for (int c = 0; c < 6; c++) {
            for (int j = 1; j < 6 - c; j++) {
                if (order[j - 1].compareToIgnoreCase(order[j]) > 0) {
                    if (order[j].equals("Empty Empty")) {
                        break;
                    }
                    String temp = order[j - 1];
                    //var temp is to store the value of the position thats going to be overwritten
                    order[j - 1] = order[j];
                    order[j] = temp;
                }
            }
        }
        for (int c=0;c<6;c++){
            if (order[c].equals("Empty Empty")) {
                break;
            }
            System.out.println(order[c]);
        }
        System.out.println("");
    }
    //Method to remove the customer from a certain position in the queue
    public void RemoveIndex(int position){
        queues[position].setFirstName("null");
        sorting();
    }
    //Method to return the details of the customer to save it in a file
    public String details(int position){
        String firstname=queues[position].getFirstName();
        String secondname=queues[position].getSecondName();
        int vehiclenumber=queues[position].getVehiclenum();
        int litres=queues[position].getNum_litres();
        return (firstname + "," + secondname + "," + vehiclenumber+ "," + litres);
    }
    //Method to save details of customers to queue from the file
    public void addfromfile(String [] deta,int position){
        queues[position].setFirstName(deta[0]);
        queues[position].setSecondName(deta[1]);
        queues[position].setVehiclenum(Integer.parseInt(deta[2]));
        queues[position].setNum_litres(Integer.parseInt(deta[3]));
    }
}
