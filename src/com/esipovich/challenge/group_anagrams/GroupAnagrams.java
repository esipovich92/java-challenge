package com.esipovich.challenge.group_anagrams;

import java.util.*;

/**
 * @author Artem Esipovich 5/11/2018
 *
 * Given an array of strings, group anagrams together.
 *
 * ["eat", "tea", "tan", "ate", "nat", "bat"]
 *
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */

public class GroupAnagrams {

    public static void main(String[] args) {
        List<List<String>> anagrams = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        anagrams.forEach(System.out::println);
    }

    private static List<List<String>> groupAnagrams(String[] anagrams){
        Map<String, List<String>> tempMap = new HashMap<>();
        for (String anagram : anagrams) {
            char[] chars = anagram.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!tempMap.containsKey(key)) {
                tempMap.put(key, new ArrayList<>());
            }
            tempMap.get(key).add(anagram);
        }
        return new ArrayList<>(tempMap.values());
    }

}
