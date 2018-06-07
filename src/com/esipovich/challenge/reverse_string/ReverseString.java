package com.esipovich.challenge.reverse_string;

/**
 * @author Artem Esipovich 6/7/2018
 *
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example:
 * Given s = "hello", return "olleh".
 */

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }

    private static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
