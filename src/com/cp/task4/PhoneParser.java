package com.cp.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by user on 21.03.2015.
 */
public class PhoneParser {

    public PhoneParser(){

    }

    private final static String pattern = ("^(([+])?\\d\\s)?(([(])?\\d{3,4}([)])?\\s)?\\d{2,4}[\\s-]\\d{2,4}[\\s-]\\d{2,4}(\\s)?");

    public boolean matches(String phoneNumber){
        return phoneNumber.matches(pattern);
    }

    public void matches(InputStream srcFileInputStream){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(srcFileInputStream))) {
            String phoneNumber;
            while((phoneNumber = reader.readLine()) != null){
                boolean result = matches(phoneNumber);
                System.out.println("Result for number: " + phoneNumber + " is " + result);
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
