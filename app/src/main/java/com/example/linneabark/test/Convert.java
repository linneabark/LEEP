package com.example.linneabark.test;

/**
 * Created by Evelinas on 2017-05-26.
 */

public class Convert {

    public String longToString(long longNumber){
        String longAsString = Long.toString(longNumber);
        return longAsString;
    }

    public Long stringToLong(String string) {
        long longNumber = -1;
        try {
            longNumber = Long.parseLong(string);
            //Annars Long.ValueOf(string)
            System.out.println("long longNumber = " + 1);
        } catch (NumberFormatException nFormatExeption) {
            System.out.println("NumberFormatExeption: " + nFormatExeption.getMessage() + " exception end.");
        }
        return longNumber;
    }
}

