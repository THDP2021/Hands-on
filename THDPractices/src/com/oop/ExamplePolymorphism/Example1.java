package com.oop.ExamplePolymorphism;

//this is our main method, inside we make two objects
public class Example1
{
    public static void main(String[] args) {
        Animal a = new Dog();
        Animal b = new Cat();

        //Call the methods from object.
        //a.makeSound();
        //b.makeSound();

    }

}

/*This is our Superclass and inside we have a method that is going to be override for the subclass in this case
   the subclass is Dog and Cat.
* */
class Animal
{
    public void makeSound() {
        System.out.println("Grr...");
    }
}

/* We use the extends keyword to reference the superclass Animal and we override our method makeSound
 * */
class Dog extends Animal
{
    //use the same method makesound but with different sout

}

/* We use the extends keyword to reference the superclass Animal and we override our method makeSound
 * */
class Cat extends Animal
{
    //use the same method makesound but with different sout
}