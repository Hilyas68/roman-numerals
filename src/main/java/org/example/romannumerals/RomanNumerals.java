package org.example.romannumerals;

public class RomanNumerals {

    private static final String[] ROMAN_NUMERALS = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    private static final int[] NUMBERS = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };


    public String convertToNumeral(int number) {

        if (number <= 0 || number >= 4000) {
            throw new IllegalArgumentException("Invalid input for Roman numeral conversion");
        }

        StringBuilder romanNumeral = new StringBuilder();

        for (int i = 0; i < NUMBERS.length; i++) {
            while (number >= NUMBERS[i]) {
                number -= NUMBERS[i];
                romanNumeral.append(ROMAN_NUMERALS[i]);
            }
        }
        return romanNumeral.toString();
    }

    public int convertToNumber(String numeral) {
        return 0;
    }
}
