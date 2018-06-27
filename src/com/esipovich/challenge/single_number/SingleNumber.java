package com.esipovich.challenge.single_number;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Artem Esipovich 27.06.2018
 *
 *  Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 *  Note:
 *  Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 *  Input: [2,2,1]
 *  Output: 1
 *
 *  Input: [4,1,2,1,2]
 *  Output: 4
 */

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    private static int singleNumber(int[] nums) {
        Set<Integer> uniqueValue = new HashSet<>();
        for (int number : nums){
            if (uniqueValue.contains(number)){
                uniqueValue.remove(number);
            } else {
                uniqueValue.add(number);
            }
        }
        return uniqueValue.iterator().next();
    }
}
