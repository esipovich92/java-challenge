package com.esipovich.challenge.two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Artem Esipovich 25.04.2018
 *
 * Write a function that, when passed a list and a target sum, returns two distinct zero-based indices
 * of any two of the numbers, whose sum is equal to the target sum.
 * If there are no two numbers, the function should return  null.
 *
 * For example, findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10)
 * should return a single dimensional array with two elements and contain any of the following pairs of indices:
 *
 * 0 and 3 (or 3 and 0) as 3 + 7 = 10
 * 1 and 5 (or 5 and 1) as 1 + 9 = 10
 * 2 and 4 (or 4 and 2) as 5 + 5 = 10
 *
 * https://www.testdome.com/d/java-interview-questions/4
 */

public class TwoSum {

    public static int[] findTwoSum(int[] list, int sum) {
        Map<Integer, Integer> preCalculated = new HashMap<>();

        for (int i = 0; i < list.length; i++) {
            preCalculated.put(list[i], i);
        }

        for (int i = 0; i < list.length; i++) {
            Integer founded = preCalculated.get(sum - list[i]);
            if (founded != null && founded != i) {
                return new int[]{founded, i};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
