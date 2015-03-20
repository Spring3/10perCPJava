package com.cp.task1;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by user on 15.03.2015.
 * Every day I'm shuffling.
 */
public class Shuffler<T> {
    public Shuffler(){

    }

    public void shuffle(T[] inputArray){
        System.out.println("One dimensional array to shuffle: \n" + Arrays.deepToString(inputArray));
        System.out.println("Shuffling...");
        int quarterOfLength = inputArray.length/4;
        if (quarterOfLength < 1){
            System.out.println("No elements to swap ('at least a quarter of the elements should be swapped')");
            return;
        }
        System.out.println("Elements to shuffle: " + quarterOfLength);
        Random rand = new Random();
        for (int i = 0; i < quarterOfLength; i++){
            int shuffleElementIndex = rand.nextInt(inputArray.length); // inputArray.length index will not be included
            int shuffleToIndex = rand.nextInt(inputArray.length);
            T takenElement = inputArray[shuffleToIndex];
            inputArray[shuffleToIndex] = inputArray[shuffleElementIndex];
            inputArray[shuffleElementIndex] = takenElement;
        }
        System.out.println("Result array: \n" + Arrays.deepToString(inputArray) + "\n");
    }

    public void shuffle(T[][] inputArray){
        System.out.println("Two dimensional array to shuffle: \n" + Arrays.deepToString(inputArray));
        System.out.println("Shuffling...");
        int quarterOfLength = (inputArray.length + inputArray[0].length)/4;
        if (quarterOfLength < 1){
            System.out.println("No elements to swap ('at least a quarter of the elements should be swapped')");
            return;
        }
        System.out.println("Elements to shuffle: " + quarterOfLength);
        Random rand = new Random();
        for (int i = 0; i < quarterOfLength; i ++){
            int shuffleRowElement = rand.nextInt(inputArray.length);
            int shuffleColumnElement = rand.nextInt(inputArray[0].length);
            int shuffleToRowIndex = rand.nextInt(inputArray.length);
            int shuffleToColumnIndex = rand.nextInt(inputArray[0].length);
            T takenElement = inputArray[shuffleToRowIndex][shuffleToColumnIndex];
            inputArray[shuffleToRowIndex][shuffleToColumnIndex] = inputArray[shuffleRowElement][shuffleColumnElement];
            inputArray[shuffleRowElement][shuffleColumnElement] = takenElement;
        }
        System.out.println("Result array: \n" + Arrays.deepToString(inputArray) + "\n");
    }
}
