package com.oop.exampleAbstraction;

//Example
// Abstract class
abstract class Animal {
    // Abstract method (does not have a body)
    public abstract void animalSound();
    // Regular method
    public void sleep() {
        //print the sound of sleepy animal

    }
}

// Subclass (inherit from Animal)
class Pig extends Animal {
    public void animalSound() {
        // The body of animalSound() is provided here
        //Print pig sound
    }
}

//Exercise 1

//Create an abstract class named Player that has two fields, role and code. Now
// create a class UserEx1 that inherits Player and set a Name propertie. Now you can
// use all 3 properties

abstract class Player{
//code here
}

class UserEx1 extends Player{
//code here
}


//Exercise 2

//Create a Vehicle abstract class with an abstract void brake, then use it in another
// class named Car and inherit the brake method and make an output that says "Car break"
// and do the same thing with a bicycle.

abstract class Vehicle {
    public void brake(){
    }
}

class Car extends Vehicle{
    public void brake() {
        //print output "car break"
    }
}

class Bicycle extends Vehicle{
    //use same method from vehicle with diferent output
        //print output for bicycle

}
