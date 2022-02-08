<<<<<<< HEAD:THDPractices/src/com/logic/Practices/src/com/ejercicios/ForLoop.java
package com.logic.Practices.src.com.ejercicios;
<<<<<<< HEAD:THDPractices/src/com/logic/Practices/src/com/ejercicios/ForLoop.java
=======
package com.logic.ForLoopTables;
>>>>>>> proof:THDPractices/src/com/logic/ForLoopTables/ForLoop.java

=======
>>>>>>> 934aa81c2dcdbf0d4b918fb59839b7bd267589f9:THDPractices/src/com/logic/Practices/src/com/ejercicios/Main.java
import java.util.Scanner;
public class ForLoop {

    public static boolean samevalue(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.println("Same value:" + array[i]);
                    return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //TABLES FROM I TO N

        int table = 0;
        int size = 0;

        System.out.println("TABLES FROM I TO N");
        System.out.print("Insert a value: ");
        table = input.nextInt();
        System.out.print("Size:");
        size = input.nextInt();

        if (table >= 0){
            for (int i = 0; i <= size ; i++) {
                System.out.println(table +" * "+ i + " = " + (table*i));
            }

        }else {
            System.out.println("Wrong value");
        }

        //REPEATED VALUES IN AN ARRANGEMENT
        int [] values = {1,2,3,4,4,6,7,8,9,10};
        System.out.println("REPEATED VALUES IN AN ARRANGEMENT");
        System.out.println("repeated values " + samevalue(values));

    }
}


