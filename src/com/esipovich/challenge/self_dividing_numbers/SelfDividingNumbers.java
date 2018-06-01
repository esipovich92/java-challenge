package com.esipovich.challenge.self_dividing_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Esipovich 6/1/2018
 *
 * A self-dividing number is a number that is divisible by every digit it contains.
 *
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 *
 * Also, a self-dividing number is not allowed to contain the digit zero.
 *
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 *
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 *
 * Note:
 *
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 */

public class SelfDividingNumbers {
    public static void main(String[] args) {
        selfDividingNumbers(1, 22).forEach(System.out::println);
    }

    private static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = left; i <= right; i++){
            String number = String.valueOf(i);
            boolean badDigit = false;
            for (int j = 0; j < number.length(); j++){
                int digit = Character.digit(number.charAt(j), 10);
                if (digit == 0 || i % digit != 0){
                    badDigit = true;
                    break;
                }
            }
            if (!badDigit) {
                numbers.add(i);
            }
        }
        return numbers;
    }
}
