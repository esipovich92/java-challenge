package com.esipovich.challenge.single_number_II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Artem Esipovich 27.06.2018
 *
 * Given a non-empty array of integers, every element appears three times except for one,
 * which appears exactly once. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Input: [2,2,3,2]
 * Output: 3
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */

public class SingleNumberII {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    private static int singleNumber(int[] nums) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        Arrays.stream(nums).forEach(element -> occurrences.merge(element, 1, Integer::sum));
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
