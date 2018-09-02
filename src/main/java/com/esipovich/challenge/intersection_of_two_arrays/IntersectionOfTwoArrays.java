package com.esipovich.challenge.intersection_of_two_arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Artem Esipovich 5/28/2018
 *
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        System.out.println(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> uniqNumbers = new HashSet<>();
        List<Integer> intersection = new ArrayList<>();
        for (int number : nums1){
            uniqNumbers.add(number);
        }
        for (int number : nums2){
            if (uniqNumbers.contains(number) && !intersection.contains(number)){
                intersection.add(number);
            }
        }
        return intersection.stream().mapToInt(i -> i).toArray();
    }

}
