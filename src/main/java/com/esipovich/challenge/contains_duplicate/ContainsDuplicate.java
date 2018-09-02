package com.esipovich.challenge.contains_duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Artem Esipovich 5/28/2018
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 */

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqNumbers = new HashSet<>();
        for (int number : nums){
            if (uniqNumbers.contains(number)){
                return true;
            }
            uniqNumbers.add(number);
        }
        return false;
    }
}
