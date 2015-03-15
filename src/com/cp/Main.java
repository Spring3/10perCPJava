package com.cp;

import com.cp.task1.Shuffler;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        /*                     Task 1
            Implement application that “shuffle” an array randomly.
            Just 25% of array elements should be “shuffled”.
            “Shuffled” positions are chosen randomly too.
            Implement unit tests for this functionality.
            Array can be multidimensional. Array is input param.
         */

        Integer[] singleDimensionalArray = new Integer[10];
        Double[][] doubleDimensionalArray = new Double[4][4];
        Random random = new Random();
        for(int i = 0; i < singleDimensionalArray.length; i++) {
            singleDimensionalArray[i] = random.nextInt(Integer.MAX_VALUE);
        }
        for (int i = 0; i < doubleDimensionalArray.length; i ++){
            for (int j = 0; j < doubleDimensionalArray[0].length; j++){
                doubleDimensionalArray[i][j] = random.nextDouble() * 100;
            }
        }

        System.out.println("TASK 1");
        Shuffler<Integer> shuffler = new Shuffler<>();
        shuffler.shuffle(singleDimensionalArray);

        Shuffler<Double> shufflerDouble = new Shuffler<>();
        shufflerDouble.shuffle(doubleDimensionalArray);


    }


}
