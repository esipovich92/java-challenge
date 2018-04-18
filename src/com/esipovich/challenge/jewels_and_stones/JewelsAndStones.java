package com.esipovich.challenge.jewels_and_stones;

/**
 * @author Artem Esipovich 18.04.2018
 *
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have. You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * © https://leetcode.com
 */

public class JewelsAndStones {
    public static int numJewelsInStones(String j, String s) {
        int countOfJewels = 0;
        for (Character c : s.toCharArray()) {
            if (j.contains(c.toString())) {
                countOfJewels++;
            }
        }
        return countOfJewels;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }
}
