package com.esipovich.challenge.maximum_swap;


/**
 * @author Artem Esipovich 6/25/2018
 *
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
 * Return the maximum valued number you could get.
 *
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 *
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 *
 * Note:
 * The given number is in the range [0, 10^8]
 */

public class MaximumSwap {

    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(9973));
    }

    private static int maximumSwap(int number){
        char[] digits = Integer.toString(number).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return number;
    }
}
