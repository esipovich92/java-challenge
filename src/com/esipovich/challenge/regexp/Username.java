package com.esipovich.challenge.regexp;

/**
 * @author Artem Esipovich 14.04.2018
 *
 * - the username must more or equals 6 letters but doesn't exceed 16 characters
 * - the username must contain only letters and optioanally one hyphen (-)
 * - the username must start with a letter and must not end with hyphen
 */

public class Username {
    public static boolean validateUserName(String username) {
        String regexp = "^(?=[a-zA-Z]+[a-zA-Z0-9]*[-]?[a-zA-Z0-9]+$)[a-zA-Z0-9-]{6,16}$";
        return username.matches(regexp);
    }

    public static void main(String[] args) {
        System.out.println(validateUserName("Artem-Esipovich"));
        System.out.println(validateUserName("Artem Esipovich"));
    }
}
