package com.oop.exampleinheritance1;

import javax.swing.*;
/*First we create the vehicle class which will be our parent class or our super class, where we are going to detail
the general characteristics that our vehicles share.
In our vehicle class, we first have a constructor in which we declare the general variables that our vehicles will have,
 then we have the method tell me general data, which, as its name says, returns the general data of a vehicle,
 which are those declared in the constructor. . The method to change the color of our vehicle called set color is also created,
 after this method the method dime color is created which returns the value assigned to color.
Afterwards, the method configures seats and its pair tell me seats is created, in which it tells us whether or not
 our vehicle has leather seats. Another couple of setter and getter methods are created to configure
 the heating of our
 vehicle and tell us if it has heating or not. We create a last couple of methods, one to assign
 the weight of the vehicle
 and another to return that weight of the vehicle to us, if the vehicle had heating and / or
 leather seats the weight increases
 if not, it remains with the initial weight of the manufacturer. To end this class we create a single method to
 return the price of the car which is called car_price.
The car class is created which will inherit from our vehicle class,
sharing all these characteristics and adding only the places it has for passengers.
A method is created that returns the data of the car regarding how many places it has available,
that is, if the car is a sedan or is it compact.
The van class is created which also inherits from vehicles.
In this class, the data that it will have unique will be load capacity
and extra seats, a constructor is created to assign this data and later a method to return it to us.
Then we create the class my vehicles in which we will be creating the instances
of our objects and calling their respective methods and then send them to print on the console.*/
public class My_vehicles {  //Our main class

    public static void main(String[] args) {


        //Here we will create our objects cars or trucks

        Car Ferrari = new Car(4); // Instantiate a class



        Van Jeep = new Van(6,500);


        Ferrari.set_color(JOptionPane.showInputDialog("Enter color: "));
        System.out.println(Ferrari.tellme_color());
        System.out.println(Ferrari.tellme_general_data());
        Ferrari.configure_seats(JOptionPane.showInputDialog("Do you have leather seats? "));
        System.out.println(Ferrari.tellme_seats());
        Ferrari.configure_heating(JOptionPane.showInputDialog("Do you have heating?: "));
        System.out.println(Ferrari.tellme_heating());
        Ferrari.vehicle_weight();
        System.out.println(Ferrari.tellmedataCar());
        System.out.println(Ferrari.tellme_vehicle_weight());
        System.out.println("The final price of the car is: "+ Ferrari.car_price());

        System.out.println("");

        Jeep.set_color(JOptionPane.showInputDialog("Enter color: "));
        System.out.println(Jeep.tellme_color());
        Jeep.configure_seats("si");
        System.out.println(Jeep.tellme_seats());
        Jeep.configure_heating("si");
        System.out.println(Jeep.tellme_heating());
        System.out.println(Jeep.tellmedataVan());
        System.out.println(Jeep.tellme_general_data());

    }

}
class Vehicles {

    //The common characteristics of a vehicle are specified

    private int wheels;  // The wheel data is encapsulated since it cannot be modified by a class other than this

    private int long_;

    private int width;

    private int motor;

    private int chassis_weight;

    private String color;

    private int total_weight;

    private boolean leather_seats, heating;



    public Vehicles(){ //Constructor method, defines the initial state of the object


        wheels=4;

        long_=2000;

        width=300;

        motor=1600;

        chassis_weight=500;


    }
    public String tellme_general_data(){  //Getter method, a data is obtained

        return "The chassis of the car has: "+ wheels+ " wheels" +
                " \nGauge: " + long_/1000 + " meters" + ", with a width of: "+ width+ " cm and a platform weight of: "
                + chassis_weight + " kg";
    }

    public void set_color( String car_color){  //Setter method, modify a value


        color = car_color;

    }

    public String tellme_color (){

        return "The color of the vehicle is: " + color;
    }

    public void  configure_seats (String leather_seats){

        if(leather_seats.equalsIgnoreCase("si")){
            this.leather_seats= true;
        }else {
            this.leather_seats=false;
        }
    }

    public String tellme_seats(){

        if(leather_seats==true){
            return "The vehicle has leather seats";

        }else{
            return "The vehicle does not have leather seats";
        }
    }

    public void configure_heating(String heating){

        if(heating.equalsIgnoreCase("si")){
            this.heating=true;

        }else{
            this.heating=false;

        }
    }

    public String tellme_heating (){

        if(heating==true){
            return "The vehicle is heated";

        }else{
            return "The vehicle has air conditioning";
        }
    }

    public String tellme_vehicle_weight(){

        return "The weight of the vehicle is: " + total_weight;
    }

    public void vehicle_weight(){

        int body_weight=500;

        total_weight= chassis_weight+body_weight;

        if (leather_seats==true){

            total_weight=total_weight+50;

        }
        if (heating==true){
            total_weight= total_weight+20;
        }


    }
    public int car_price(){
        int final_price=10000;

        if (leather_seats==true){
            final_price+=200;

        }
        if (heating==true){
            final_price+= 1500;
        }

        return final_price;
    }
}
class Car extends Vehicles{

    private int places;

    public Car(int places){

        super();

        this.places=places;

    }

    public String tellmedataCar(){

        if(places>=4 && places<6){
            return "Your vehicle is a sedan";
        }
        else{
            return "Your vehicle is compact";
        }
    }
}
class Van extends Vehicles { // The van class inherits from the vehicles class

    private int load_capacity;

    private int extra_places;

    public Van (int extra_places, int load_capacity){

        super(); //call the parent class constructor (vehicles)

        this.load_capacity=load_capacity;
        this.extra_places=extra_places;


    }
    public String tellmedataVan(){
        return "The load capacity is: "+ load_capacity+
                " and the places are: "+ extra_places;
    }



}


