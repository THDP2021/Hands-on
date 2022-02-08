package com.oop.exampleEncapsulation;

import java.util.Scanner;

//Exercise 1: Encapsulation
// This first exercise it's about create a new class called BankAccount, in this class, you have one parameter,
//this parameter will be an account number for a bank. Account number can be an int or Integer.
//NOTE: Your account number require to be private
// You need to register a new client,then you have to ask for an account number (input),
//Then you create a new space to save your date(this space will be an object of your class BankAccount)
//At final, you need to call your method (method of BankAccount class) that brings the account number that you
//had already registered. Print the value of the account number calling to your class method.

public class FirstExample {
public static void main(String[] args) {
    System.out.print("Hello there, this is the second exercise to promote the knowledge about " +
            "Object Oriented Programming: Encapsulation\n");
    Scanner sc=new Scanner(System.in);
    System.out.println("Could you provide your account number?:\n");
    int accountNumber=sc.nextInt();

    //create a new object since the bankaccount class

    //set the account number gived in scanner.

    //print the account number registered;
}
}

////////////////// BANKACCOUNT CLASS /////////////////////
//In this class you only have 1 attribute.

class BankAccount{

    //int account number
    //getter and setter

}
