package com.esipovich.challenge.goat_latin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Artem Esipovich 24.07.2018
 *
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * - If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 * - If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * - Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 *
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 *
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 */

public class GoatLatin {
    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
        System.out.println(toGoatLatin("yDumm"));
    }

    private static String toGoatLatin(String sentence) {
        StringBuilder goatLatin = new StringBuilder();
        StringBuilder lettersToAdd = new StringBuilder("a");
        for (String word : sentence.split(" ")) {
            char firstLetter = word.charAt(0);
            if (!VOWELS.contains(firstLetter)){
                word = word.substring(1) + firstLetter;
            }
            goatLatin.append(word);
            goatLatin.append("ma").append(lettersToAdd).append(" ");
            lettersToAdd.append("a");
        }
        goatLatin.deleteCharAt(goatLatin.length() - 1);
        return goatLatin.toString();
    }
}