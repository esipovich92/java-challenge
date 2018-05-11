package com.esipovich.challenge.group_anagrams;

import java.util.ArrayList;
import java.util.List;

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
    }

    private static List<List<String>> groupAnagrams(String[] anagrams){
        return new ArrayList<>();
    }

}
