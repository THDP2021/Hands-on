package com.oop.ExamplePolymorphism;


/* In the main we make the objects to instance the classes
 * */
public class Example2
{
    public static void main(String[] args)
    {
        //Create object from person class and one object from student class with correspond attributes.
        //Person p1 = new Person
        //Person p2 = new Student

        //print polymorphism methods with each object that were declared
        //sout(p1.polymorphism)
        //sout(p2.polymorphism)

    }
}
/* This is the super class, its encapsuled two atributtes, initialized the constructor with two parameters and the getters
 *  and setters, and made a method */
class Person
{
    //attributes name and id
    private String name;
    private int id;

    //constructor with name and id


    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //method string polymorphism print name and id

}

/* The class Student will inherit from the Person class to get his attributes, in the constructor we use all the parameters
 * that we are going to recieve in the main method, we use Super keyword with the parameters name and id, because is already
 * inicialized in Superclass constructor, and finally we override the method  */
class Student extends Person
{
    private int age;
    private int grade;

    //Create a constructor with name, id, age, grade



//Need to override the method polymorphism to create the new method for this class with more attributes as
    //age and grade.
    //@Override
    //public String polimorfismo()


}
