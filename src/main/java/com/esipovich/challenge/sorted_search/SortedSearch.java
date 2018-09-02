package com.esipovich.challenge.sorted_search;

import java.util.Arrays;

/**
 * @author Artem Esipovich 24.04.2018
 *
 * Implement function countNumbers that accepts a sorted array of integers and counts the number of array elements
 * that are less than the parameter lessThan.
 *
 * For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 because
 * there are two array elements less than 4.
 *
 * https://www.testdome.com/d/java-interview-questions/4
 */

public class SortedSearch {

    public static int countNumbers(int[] sortedArray, int lessThan) {
        int indexOfKey = Arrays.binarySearch(sortedArray, lessThan);
        return indexOfKey < 0 ? (- indexOfKey) - 1 : indexOfKey;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }
}
