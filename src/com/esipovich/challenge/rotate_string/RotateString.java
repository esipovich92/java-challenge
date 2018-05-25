package com.esipovich.challenge.rotate_string;

/**
 * @author Artem Esipovich 5/25/2018
 *
 * We are given two strings, A and B.
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position.
 * For example, if A = 'abcde', then it will be 'bcdea' after one shift on A.
 * Return True if and only if A can become B after some number of shifts on A.
 */

public class RotateString {

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
    }

    private static boolean rotateString(String firstString, String secondString) {
        if (firstString.equals(secondString)){
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder(firstString);
        for (int i = 0; i < stringBuilder.length(); i++){
            char c = stringBuilder.charAt(0);
            stringBuilder.deleteCharAt(0);
            stringBuilder.append(c);
            if (stringBuilder.toString().equals(secondString)){
                return true;
            }
        }
        return false;
    }
}
