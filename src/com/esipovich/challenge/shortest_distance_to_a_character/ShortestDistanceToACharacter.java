package com.esipovich.challenge.shortest_distance_to_a_character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Artem Esipovich 05.07.2018
 *
 * Given a string S and a character C, return an array of integers representing the shortest distance
 * from the character C in the string.
 *
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 * Note:
 *
 * - S string length is in [1, 10000].
 * - C is a single character, and guaranteed to be in string S.
 * - All letters in S and C are lowercase.
 */

public class ShortestDistanceToACharacter {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
    }

    private static int[] shortestToChar(String text, char symbol) {
        int[] distanceArray = new int[text.length()];

        List<Integer> indexes = findIndexes(text, symbol);

        fillFirstDistance(distanceArray, indexes);

        replaceWithShortestDistances(distanceArray, indexes);

        return distanceArray;
    }

    private static List<Integer> findIndexes(String text, char symbol){
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == symbol){
                indexes.add(i);
            }
        }
        return indexes;
    }

    private static void fillFirstDistance(int[] distances, List<Integer> indexes){
        for (int i = 0; i < distances.length; i++){
            distances[i] = Math.abs(i - indexes.get(0));
        }
    }

    private static void replaceWithShortestDistances(int[] distances, List<Integer> indexes){
        for (int i = 1; i < indexes.size(); i++){
            for (int j = 0; j < distances.length; j ++){
                int currentDistance = Math.abs(j - indexes.get(i));
                if (currentDistance < distances[j]){
                    distances[j] = currentDistance;
                }
            }
        }
    }
}
