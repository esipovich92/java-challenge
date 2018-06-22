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

    public static void main(String[] args) {
        numberToConsole(94568547);
    }

    private static void numberToConsole(int... number){
        int numberFromConsole = number.length == 0 ? readNumber() : number[0];
        int[] digits = getDigits(numberFromConsole);
        for (int line = 0; line < 7; line++){
            for (int digit : digits) {
                System.out.print(views[line][digit]);
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
