package com.cp;

import com.cp.task4.PhoneParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("TASK 4");
        PhoneParser phoneParser = new PhoneParser();
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        boolean doParsilis = false;
        try {
            while(!doParsilis) {
                System.out.println("Please, enter a phone number");
                String phoneNumber = reader.readLine();
                System.out.println("Result: " + phoneParser.matches(phoneNumber));
                System.out.println("Let's give it another try?(y/n)");
                String answer = reader.readLine();
                if (answer.equals("n") || answer.equals("N")){
                    doParsilis = true;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
