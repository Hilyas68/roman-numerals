package org.example.romannumerals;

import java.util.Arrays;

public class RomanNumerals {

    private static final String[] ROMAN_NUMERALS = {"I", "V", "X", "L", "C", "D", "M"};
    private static final int[] NUMBERS = {1, 5, 10, 50, 100, 500, 1000};


    public String convertToNumeral(int number) {

        if (number <= 0 || number >= 4000) {
            throw new IllegalArgumentException("Invalid input for Roman numeral conversion");
        }
        switch (number) {
            case 4:
                return "IV";
            case 9:
                return "IX";
            case 40:
                return "XL";
            case 90:
                return "XC";
            case 400:
                return "CD";
            case 900:
                return "CM";
            default:
                StringBuilder romanNumeral = new StringBuilder();

                for (int i = ROMAN_NUMERALS.length - 1; i >= 0; i--) {
                    while (number >= NUMBERS[i]) {
                        if (i == 0 || NUMBERS[i - 1] <= number / 2) {
                            romanNumeral.append(ROMAN_NUMERALS[i]);
                            number -= NUMBERS[i];
                        } else {
                            // If the current Roman numeral is less than half of the number, then we can't subtract it
                            // without going below 1. In this case, we just append the Roman numeral as-is.
                            romanNumeral.append(ROMAN_NUMERALS[i]);
                        }
                    }
                }

                return romanNumeral.toString();
        }
    }

    public int convertToNumber(String numeral) {

        if (numeral == null || numeral.isEmpty()) {
            throw new IllegalArgumentException("Invalid input for Roman numeral conversion");
        }

        int result = 0;
        int prevValue = 0;

        for (int i = numeral.length() - 1; i >= 0; i--) {
            char currentChar = numeral.charAt(i);
            int currentIndex = Arrays.asList(ROMAN_NUMERALS).indexOf(String.valueOf(currentChar));

            if (currentIndex == -1) {
                throw new IllegalArgumentException("Invalid input for Roman numeral conversion");
            }

            int currentValue = NUMBERS[currentIndex];

            if (currentValue >= prevValue) {
                result += currentValue;
            } else {
                result -= currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }
}
