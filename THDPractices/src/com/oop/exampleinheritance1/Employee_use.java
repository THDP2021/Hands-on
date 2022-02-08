package com.oop.exampleinheritance1;

import java.util.Date;
import java.util.GregorianCalendar;

        /*We create a class called employee which will be our super class
        We declare in it the essential characteristics that an employee has, name, salary, contract registration
        and his id, then we create our constructor method which will receive 5 parameters that will be name,
        salary, year, month and day. In this example we are going to have two constructor methods
        since sometimes there is the possibility of registering an employee without knowing in detail
        his duel or his contract registration, so we are going to create a constructor that receives
        only one parameter that will be the name and return us a generic salary and
        a generic contract date.
        After that, we are going to create a getter method that returns the name and id of
        the employee, this id has to be static so that it is encoded each time a new employee is added
        Then we create two getter methods plus one to give us the salary and another for the contract registration.
        Later we create a setter method with which it allows us to make an increase in the salary of the employees.
        We are going to create a class called headquarters which will inherit from employee.
        the head class will inherit the constructor method from the parent class, the one with 5 parameters.
        In this class the difference is that there will be a setter method which will
        establish an incentive to the salary of the bosses.
        To finish we will have to create a class of my employees where the objects of our classes will be instantiated.*/


public class Employee_use{

    public static void main(String[] args) {


        //Create array of 5 Employees
        Employee[] myEmployee=new Employee [5];
        //Create a system_chief since class leadership
        //leadership systems_chief= new leadership ()

        //setIncentive
        //systems_chief.setIncentive(2000);

        //Last employee register will be the chief.
        //myEmployee[4]= systems_chief;


        //adding an salary raise for all the employees, use salary_raise method.
        for(int i=0;i<5;i++){
            //method
        }

        //Print the information of employees, name, salary, contract date
        for(int i=0; i<5;i++){

        }
    }

}

class Employee{


    private String name;
    private double salary;
    private Date high_Contract;
    private int Id;
    private static int nextId=1;



    public Employee(String nom, double sue, int year, int month, int day){

        name=nom;
        salary= sue;
        GregorianCalendar calendar= new GregorianCalendar(year, month-1,day);
        high_Contract=calendar.getTime();
        ++nextId;
        Id=nextId;

    }

    public Employee (String nom){


        this(nom,30000,2000,01,01);

    }

    public String get_name(){ //metodo getter

        return name + " Id: "+ Id;

    }
    public double giveme_salary(){ //metodo getter
        return salary;

    }

    public Date giveme_ContractDate(){ //metodo getter

        return high_Contract;

    }

    // Create method salary_raise(percentage){
    //salary + salary*percentage=new salary
    // }


}
class leadership extends Employee {

    private double incentive;

    public leadership (String nom, double sue, int agno, int mes, int dia){

        super(nom, sue, agno, mes, dia);

    }

    public void setIncentive(double incentive){
        this.incentive= incentive;
    }


    public double givemeSalary(){

        double salary_boss= super.giveme_salary();

        return salary_boss+incentive;
    }
}
