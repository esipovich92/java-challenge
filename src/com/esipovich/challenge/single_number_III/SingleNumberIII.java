package com.esipovich.challenge.single_number_III;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Artem Esipovich 27.06.2018
 *
 * Given an array of numbers nums, in which exactly two elements appear only once
 * and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 */

public class SingleNumberIII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }

    private static int[] singleNumber(int[] nums) {
        Set<Integer> uniqueValues = new HashSet<>();
        for (Integer number : nums){
            if (uniqueValues.contains(number)){
                uniqueValues.remove(number);
            } else {
                uniqueValues.add(number);
            }
        }
        return uniqueValues.stream().mapToInt(Number::intValue).toArray();
    }
}
