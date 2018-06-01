package com.esipovich.challenge.add_digits;

/**
 * @author Artem Esipovich 5/31/2018
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 *
 */

public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {
        int sum = 0;
        while (num > 0){
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }
}
