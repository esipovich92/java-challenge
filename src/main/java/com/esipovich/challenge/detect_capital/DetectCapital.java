package com.esipovich.challenge.detect_capital;

/**
 * @author Artem Esipovich 5/15/2018
 *
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * - All letters in this word are capitals, like "USA".
 * - All letters in this word are not capitals, like "leetcode".
 * - Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 * ex1. USA -> true, ex2. FlaG -> false
 */

public class DetectCapital {

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("FlaG"));
    }

    private static boolean detectCapitalUse(String word){
        if (word.equals(word.toUpperCase())){
            return true;
        }
        if (word.equals(word.toLowerCase())){
            return true;
        }
        if (word.length() > 1){
            String charAtFirst = word.substring(0, 1);
            String lastChars = word.substring(1);
            return charAtFirst.equals(charAtFirst.toUpperCase()) && lastChars.equals(lastChars.toLowerCase());
        }
        return false;
    }
}
