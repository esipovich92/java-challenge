package com.esipovich.challenge.keyboard_row;

import java.util.*;

/**
 * @author Artem Esipovich 06.07.2018
 *
 * Given a List of words, return the words that can be typed using letters of alphabet on only one
 * row's of American keyboard like the example below.
 *
 * First line: qwertyuiop
 * Second line: asdfghjkl
 * Third line: zxcvbnm
 *
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 *
 * Note:
 * - You may use one character in the keyboard more than once.
 * - You may assume the input string will only contain letters of alphabet.
 */

public class KeyboardRow {
    private static final Set<Character> FIRST_LINE =
            new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
    private static final Set<Character> SECOND_LINE =
            new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
    private static final Set<Character> THIRD_LINE =
            new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
        System.out.println(Arrays.toString(findWords(new String[]{"a", "b"})));
    }

    private static String[] findWords(String[] words) {
        Set<Character> keyboardLine;
        List<String> wordsFromOneLine = new ArrayList<>();
        for (String word : words){
            if (word.length() == 1){
                wordsFromOneLine.add(word);
                continue;
            }
            String wordIgnoreCase = word.toLowerCase();
            keyboardLine = getKeyboardLine(wordIgnoreCase.charAt(0));
            for (int i = 1; i < word.length(); i++){
                if (!keyboardLine.contains(wordIgnoreCase.charAt(i))){
                    break;
                }
                if (i == word.length() - 1) {
                    wordsFromOneLine.add(word);
                }
            }
        }
        return wordsFromOneLine.toArray(new String[0]);
    }

    private static Set<Character> getKeyboardLine(char letter){
        if (FIRST_LINE.contains(letter)) return FIRST_LINE;
        if (SECOND_LINE.contains(letter)) return SECOND_LINE;
        return THIRD_LINE;
    }
}
