package com.esipovich.challenge.number_to_console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Artem Esipovich 6/22/2018
 *
 * Write a program, which will read a number from a console and print it in such way:
 * input: 41072819
 * output:
 *    *    *    ***   *****  ***    ***    *   ****
 *   **   **   *   *      * *   *  *   *  **  *   *
 *  * *    *  *     *    *  *  *   *   *   *  *   *
 * *  *    *  *     *   *     *     ***    *   ****
 * ******  *  *     *  *     *     *   *   *      *
 *    *    *   *   *  *     *      *   *   *      *
 *    *   ***   ***   *     *****   ***   ***     *
 *
 * Additional: make so, that a number would consits of little numbers instead of '*'
 */

public class NumberToConsole {

    private static final String[][] views = {

            {"  ***  ", "   *   ", "  ***  ", "  ***  ", "    *  ", " ***** ", "  ***  ", " ***** ", "  ***  ", "  ***  "},
            {" *   * ", "  **   ", " *   * ", " *   * ", "   **  ", " *     ", " *   * ", "     * ", " *   * ", " *   * "},
            {"*     *", " * *   ", " *   * ", "     * ", "  * *  ", " *     ", " *     ", "    *  ", " *   * ", " *   * "},
            {"*     *", "   *   ", "    *  ", "  ***  ", " *  *  ", " ****  ", " ****  ", "   *   ", "  ***  ", "  ***  "},
            {"*     *", "   *   ", "   *   ", "     * ", " ***** ", "     * ", " *   * ", "  *    ", " *   * ", "     * "},
            {" *   * ", "   *   ", "  *    ", " *   * ", "    *  ", " *   * ", " *   * ", "  *    ", " *   * ", "     * "},
            {"  ***  ", " ***** ", " ***** ", "  ***  ", "    *  ", "  ***  ", "  ***  ", "  *    ", "  ***  ", "  ***  "}
    };
    private static final String[][] additionalViews = {

            {"  000  ", "   1   ", "  222  ", "  333  ", "    4  ", " 55555 ", "  666  ", " 77777 ", "  888  ", "  999  "},
            {" 0   0 ", "  11   ", " 2   2 ", " 3   3 ", "   44  ", " 5     ", " 6   6 ", "     7 ", " 8   8 ", " 9   9 "},
            {"0     0", " 1 1   ", " 2   2 ", "     3 ", "  4 4  ", " 5     ", " 6     ", "    7  ", " 8   8 ", " 9   9 "},
            {"0     0", "   1   ", "    2  ", "  333  ", " 4  4  ", " 5555  ", " 6666  ", "   7   ", "  888  ", "  999  "},
            {"0     0", "   1   ", "   2   ", "     3 ", " 44444 ", "     5 ", " 6   6 ", "  7    ", " 8   8 ", "     9 "},
            {" 0   0 ", "   1   ", "  2    ", " 3   3 ", "    4  ", " 5   5 ", " 6   6 ", "  7    ", " 8   8 ", "     9 "},
            {"  000  ", " 11111 ", " 22222 ", "  333  ", "    4  ", "  555  ", "  666  ", "  7    ", "  888  ", "  999  "}
    };

    public static void main(String[] args) {
        numberToConsole( false, 94568547);
        numberToConsole( true, 94568547);
    }

    private static void numberToConsole(boolean isAdditional, int... number){
        int numberFromConsole = number.length == 0 ? readNumber() : number[0];
        int[] digits = getDigits(numberFromConsole);
        String[][] viewToUse = isAdditional ? additionalViews : views;
        for (int line = 0; line < 7; line++){
            for (int digit : digits) {
                System.out.print(viewToUse[line][digit]);
            }
            System.out.println();
        }

    }

    private static int readNumber(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int[] getDigits(int number){
        List<Integer> digits = new ArrayList<>();
        while (number > 0){
            digits.add(0, number % 10);
            number = number / 10;
        }
        return digits.stream().mapToInt(Integer::intValue).toArray();
    }
}
