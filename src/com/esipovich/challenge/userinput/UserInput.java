package com.esipovich.challenge.userinput;

/**
 * @author Artem Esipovich 12.04.2018
 *
 * UserInput controls two types of user inputs:
 * StringInput, which accepts any text and DigitInput, which accepts only digits
 *
 * Need to implement the class StringInput that contains:
 * method void add(char c) - adds the given character to the current value
 * method String getValue() - returns the current value
 *
 * Need to implement the class DigitInput that:
 * Inherits from StringInput
 * Overrides the add method so that each non-numeric character is ignored
 *
 * Level: easy
 */

public class UserInput {

    public static class StringInput {
        private String value = "";

        public void add(char c) {
            value += c;
        }

        public String getValue() {
            return value;
        }
    }

    public static class DigitInput extends StringInput{
        @Override
        public void add(char c) {
            if (Character.isDigit(c)) {
                super.add(c);
            }
        }
    }

    public static void main(String[] args) {
        StringInput input = new DigitInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
