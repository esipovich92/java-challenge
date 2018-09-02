package com.esipovich.challenge.string_compression;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Artem Esipovich 26.06.2018
 *
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 *
 * Follow up:
 * Could you solve it using only O(1) extra space?
 *
 * Input:
 * ["a","a","b","b","c","c","c"]
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 *
 * Input:
 * ["a"]
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * Explanation:
 * Nothing is replaced.
 *
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 *
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 */

public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }

    private static int compress(char[] chars){
        Map<Character, Integer> occurencies = new HashMap<>();
        for (char symbol : chars) {
            occurencies.merge(symbol, 1, Integer::sum);
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : occurencies.entrySet()){
            result.append(entry.getKey());
            result.append(entry.getValue() == 1 ? "" : entry.getValue());
        }
        chars = result.toString().toCharArray();
        return chars.length;
    }
}
