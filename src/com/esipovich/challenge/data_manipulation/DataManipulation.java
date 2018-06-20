package com.esipovich.challenge.data_manipulation;


import java.util.Random;

/**
 * @author Artem Esipovich 20.06.2018
 *
 * method replaceLetters(String letters):
 *  - should replace '?' with a random letter from a to z
 *  - do not replace another symbol
 *
 * method replaceNumbers(String numbers):
 *  - should replace '#' with a random digit from 0 to 9
 *  - do not replace another symbol
 *
 * method replace replaceAll(String line):
 *  - should implement both
 *
 */

public class DataManipulation {

    public String replaceLetters(String letters) {
        StringBuilder letterifiedString = new StringBuilder(letters);
        Random randomNumber = new Random();
        for (int i = 0; i < letters.length(); i++){
            if ('?' == letters.charAt(i)){
                letterifiedString.setCharAt(i, (char) (randomNumber.nextInt(26) + 'a'));
            } else {
                letterifiedString.setCharAt(i, letters.charAt(i));
            }
        }
        return letterifiedString.toString();
    }

    public String replaceNumbers(String numbers) {
        StringBuilder numerifiedString = new StringBuilder();
        Random randomNumber = new Random();
        for (int i = 0; i < numbers.length(); i++){
            if ('#' == numbers.charAt(i)){
                numerifiedString.append(randomNumber.nextInt(10));
            } else {
                numerifiedString.append(numbers.charAt(i));
            }
        }
        return numerifiedString.toString();
    }

    public String replaceAll(String line) {
        StringBuilder bothifiedString = new StringBuilder(line);
        Random randomNumber = new Random();
        for (int i = 0; i < line.length(); i++){
            if ('?' == line.charAt(i)){
                bothifiedString.setCharAt(i, (char) (randomNumber.nextInt(26) + 'a'));
            } else if ('#' == line.charAt(i)){
                bothifiedString.setCharAt(i, Character.forDigit(randomNumber.nextInt(10), 10));
            }
        }
        return bothifiedString.toString();
    }

}
