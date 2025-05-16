package org.example;

public class NumericCheck {
    public static boolean isNumeric(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
