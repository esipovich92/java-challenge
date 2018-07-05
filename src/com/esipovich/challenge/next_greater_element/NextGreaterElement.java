package com.esipovich.challenge.next_greater_element;

import java.util.Arrays;

/**
 * @author Artem Esipovich 05.07.2018
 *
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 * If it does not exist, output -1 for this number.
 *
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 *
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 *
 * Note:
 * - All elements in nums1 and nums2 are unique.
 * - The length of both nums1 and nums2 would not exceed 1000.
 */

public class NextGreaterElement {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] finalArray = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++){
            int greaterNumber = -1;
            boolean isNumberFound = false;
            for (int numberFromSecondArray : nums2) {
                if (numberFromSecondArray == nums1[i]) {
                    isNumberFound = true;
                }
                if (isNumberFound && numberFromSecondArray > nums1[i]) {
                    greaterNumber = numberFromSecondArray;
                    break;
                }
            }
            finalArray[i] = greaterNumber;
        }
        return finalArray;
    }
}
