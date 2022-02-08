package com.logic;

import java.util.Scanner;

interface normalInterface{
    void reverseWordMethod(String thestring);
}

interface FuncInterface{
    void printReverseWord(String secondString);
}

public class ReverseString implements normalInterface{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String word;
        ReverseString reverseString = new ReverseString();

        System.out.println("Please enter the string: ");
        word = scan.nextLine();

        reverseString.reverseWordMethod(word);

        FuncInterface fobj = (String secondString) -> System.out.println(secondString);

        fobj.printReverseWord(word);

    }

    @Override
    public void reverseWordMethod(String thestring) {
        char ch;
        String reverseword="";
        for (int i=0; i<thestring.length(); i++)
        {
            ch= thestring.charAt(i); //extracts each character
            reverseword= ch+reverseword; //adds each character in front of the existing string
        }
        System.out.println(reverseword);
    }
}
