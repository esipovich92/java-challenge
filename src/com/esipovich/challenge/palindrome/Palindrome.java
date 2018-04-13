package com.esipovich.challenge.palindrome;

/**
 * @author Artem Esipovich 05.04.2018
 *
 * Create a function which checks if a given word is palindrome. Character case should be ignored
 *
 */

public class Palindrome {
    private static boolean isPalindrome(String word) {
        StringBuilder wordToReverse = new StringBuilder(word);
        wordToReverse.reverse();
        return word.equalsIgnoreCase(wordToReverse.toString());
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Palindrom"));
        System.out.println(Palindrome.isPalindrome("Kolok"));
    }
}
