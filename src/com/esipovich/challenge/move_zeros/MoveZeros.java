package com.esipovich.challenge.move_zeros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Artem Esipovich 12.07.2018
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 * - You must do this in-place without making a copy of the array.
 * - Minimize the total number of operations.
 *
 */

public class MoveZeros {

    public static void main(String[] args) {
        int[] arrayWithZeros = new int[]{0,1,0,3,12};
        moveZeroes(arrayWithZeros);
        System.out.println(Arrays.toString(arrayWithZeros));
        arrayWithZeros = new int[]{0,1,0,3,12};
        moveZeroesOptimized(arrayWithZeros);
        System.out.println(Arrays.toString(arrayWithZeros));
    }

    private static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length - 1; j++){
                if ((nums[j] == 0) && (nums[j + 1] != 0)){
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                }
            }
        }
    }

    private static void moveZeroesOptimized(int[] nums) {
        List<Integer> zerosMoved = new ArrayList<>();
        int lastIndex = 0;
        for (int num : nums) {
            if (num != 0) {
                zerosMoved.add(lastIndex, num);
                lastIndex += 1;
            } else {
                zerosMoved.add(0);
            }
        }
        for (int i = 0; i < nums.length; i++){
            nums[i] = zerosMoved.get(i);
        }
    }
}
