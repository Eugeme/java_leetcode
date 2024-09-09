// https://leetcode.com/problems/roman-to-integer/


class Solution {
    // Method to convert a Roman numeral string to an integer
    public int romanToInt(String s) {
        // Step 1: Reverse the string manually
        String reversed = reverseString(s);

        // Step 2: Convert each Roman numeral character to its integer value
        int[] values = new int[reversed.length()];
        for (int i = 0; i < reversed.length(); i++) {
            values[i] = romanCharToInt(reversed.charAt(i));
        }

        // Step 3: Iterate through the values array and apply the Roman numeral rules
        int counter = 0;
        for (int i = 0; i < values.length; i++) {
            if (i + 1 < values.length && values[i] > values[i + 1]) {
                // If the current value is greater than the next, subtract the next from the current
                counter += values[i] - values[i + 1];
                i++; // Skip the next element since it was used for subtraction
            } else {
                // Otherwise, just add the current value
                counter += values[i];
            }
        }

        return counter;
    }

    // Helper method to reverse a string
    private String reverseString(String s) {
        char[] reversed = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            reversed[i] = s.charAt(s.length() - 1 - i);
        }
        return new String(reversed);
    }

    // Helper method to convert a Roman numeral character to its integer value
    private int romanCharToInt(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0; // This should never happen for valid Roman numerals
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: LVIII
        String roman1 = "LVIII";
        System.out.println("LVIII => " + solution.romanToInt(roman1));  // Output: 58

        // Example 2: MCMXCIV
        String roman2 = "MCMXCIV";
        System.out.println("MCMXCIV => " + solution.romanToInt(roman2)); // Output: 1994

        // Example 3: III
        String roman3 = "III";
        System.out.println("III => " + solution.romanToInt(roman3)); // Output: 3

        // Example 4: IX
        String roman4 = "IX";
        System.out.println("IX => " + solution.romanToInt(roman4)); // Output: 9

        // Example 5: XLII
        String roman5 = "XLII";
        System.out.println("XLII => " + solution.romanToInt(roman5)); // Output: 42

        // Example 6: XC
        String roman6 = "XC";
        System.out.println("XC => " + solution.romanToInt(roman6)); // Output: 90

        // Example 7: CDXLIV
        String roman7 = "CDXLIV";
        System.out.println("CDXLIV => " + solution.romanToInt(roman7)); // Output: 444

        // Example 8: DCCCXLV
        String roman8 = "DCCCXLV";
        System.out.println("DCCCXLV => " + solution.romanToInt(roman8)); // Output: 845

        // Example 9: MMXXI
        String roman9 = "MMXXI";
        System.out.println("MMXXI => " + solution.romanToInt(roman9)); // Output: 2021

        // Example 10: MMMCMXCIX
        String roman10 = "MMMCMXCIX";
        System.out.println("MMMCMXCIX => " + solution.romanToInt(roman10)); // Output: 3999
    }
}
