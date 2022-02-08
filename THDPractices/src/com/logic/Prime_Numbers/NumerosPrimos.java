/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD:THDPractices/src/com/logic/Prime_Numbers/src/numerosprimos/NumerosPrimos.java
package com.logic.Prime_Numbers.src.numerosprimos;
=======
package com.logic.Prime_Numbers;
>>>>>>> proof:THDPractices/src/com/logic/Prime_Numbers/NumerosPrimos.java


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author Christian Baruch
 */
public class NumerosPrimos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("Java Programming ");
            System.out.println("Logic Programming Exercises:");
            System.out.println(" 1: Prime numbers");
            System.out.println(" 2: Factorial");
            System.out.println(" 3: Fibonnacci");
            System.out.println(" 4: Exit");
            try {
                System.out.println(" Enter an option: ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        Scanner sc = new Scanner(System.in);
                        System.out.println("You chose the Prime Numbers Option");
                        int num;
                        int a = 0;
                        System.out.println("Enter number: ");
                        num = sc.nextInt();

                        for (int i = 1; i <= num; i++) {
                            if (num % i == 0) {
                                a++;
                            }
                        }
                        if (a == 2) {
                            System.out.println("The Number " + num + " is Prime\n\n");
                        } else {
                            System.out.println("The Number " + num + " isn't Prime\n\n");
                        }
                        break;

                    case 2:
                        Scanner leer = new Scanner(System.in);
                        System.out.println("You chose the Factorial Option");
                        System.out.println("Enter number: ");
                        int n = leer.nextInt();

                        System.out.println(LongStream.rangeClosed(1, n)
                                .reduce(1, (long n1, long n2) -> n1 * n2));

//                     int factorial = 1;
//                     for(int i = 1; i <= n; i++){
//                         factorial = factorial * i;
//                     }
//                    System.out.println("The Factorial of " +n+ " is: "+factorial+ "\n\n");
                        break;

                    case 3:
                        Scanner fibo = new Scanner(System.in);
                        System.out.println("You chose the Fibonacci Option");
                        System.out.println("Enter how many numbers you want to generate: ");
                        int numfibo = fibo.nextInt();

                        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                                .limit(numfibo)
                                .map(t -> t[0])
                                .forEach(x -> System.out.println(x));
//                    int f =0;
//                    int t1 = 1;
//                    int t2;
//                     System.out.println(" Your Fibonacci is:");
//                    for(int i = 1; i <= numfibo; i++){
//                           t2 = f;
//                           f = t1 + f;
//                           t1 = t2;
//                           System.out.println(t1);
//                     }
//
                        break;

                    case 4:
                        System.out.println("Thanks for using the program, come back soon");
                        salir = true;
                        break;
                    default:
                        System.out.println("ERROR");
                        System.out.println("Please enter a valid menu option\n\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR");
                System.out.println("Enter a valid option, Enter a number\n\n");
                sn.next();
            }
        }

    }
}
