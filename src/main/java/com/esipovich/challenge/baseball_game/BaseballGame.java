package com.esipovich.challenge.baseball_game;

import java.util.Stack;

/**
 * @author Artem Esipovich 03.07.2018
 *
 * You're now a baseball game point recorder.
 *
 * Given a list of strings, each string can be one of the 4 following types:
 *
 * Integer (one round's score): Directly represents the number of points you get in this round.
 * - "+" (one round's score): Represents that the points you get in this round are the sum
 * of the last two valid round's points.
 * - "D" (one round's score): Represents that the points you get in this round are the doubled
 * data of the last valid round's points.
 * - "C" (an operation, which isn't a round's score): Represents the last valid round's points
 * you get were invalid and should be removed.
 * Each round's operation is permanent and could have an impact on the round before and the round after.
 *
 * You need to return the sum of the points you could get in all the rounds.
 *
 * Input: ["5","2","C","D","+"]
 * Output: 30
 *
 * Input: ["5","-2","4","C","D","9","+","+"]
 * Output: 27
 *
 * Note:
 * The size of the input list will be between 1 and 1000.
 * Every integer represented in the list will be between -30000 and 30000.
 *
 */

public class BaseballGame {
    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }

    private static int calPoints(String[] operations) {
        Stack<Integer> points = new Stack<>();
        for (String operation : operations){
            if ("+".equals(operation)){
                int lastPoint = points.pop();
                int newLastPoint = lastPoint + points.peek();
                points.push(lastPoint);
                points.push(newLastPoint);
            } else if ("D".equals(operation)){
                points.push(points.peek() * 2);
            } else if ("C".equals(operation)){
                points.pop();
            } else {
                points.push(Integer.parseInt(operation));
            }
        }
        int sum = 0;
        while (!points.empty()){
            sum = sum + points.pop();
        }
        return sum;
    }
}
