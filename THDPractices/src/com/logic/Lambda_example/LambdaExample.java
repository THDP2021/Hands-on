package com.logic.Lambda_example;
import com.logic.Lambda_example.Average;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExample {

    public static void main(String[] args) {

        //Example number one

        //Getting the interface and printing its function
        Average avr = (double x, double y) -> (x+y)/2;
        System.out.println(avr.calculate(2,6));


        //Example number two

        List<Integer> nums = Arrays.asList(1, 2, 3, 4,5,6,7,8);

        //List where the result will be storage
        List<Integer> results = new ArrayList<Integer>();

        results = nums.stream()
                .filter( n->n % 2 == 0)  //Anonymous function to filter pair numbers
                .collect(Collectors.toList());

        System.out.println(results);

    }
}
