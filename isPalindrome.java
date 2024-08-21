// https://leetcode.com/problems/palindrome-number/description/
// Given an integer x, return true if x is a palindrome, and false otherwise.

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int originalX = x;
        int digits = 1;
        int divisor = 10;

        ArrayList<Integer> numbers = new ArrayList<>();

        while (originalX / digits >= 10) {
            int digit = (originalX % divisor) / digits;
            numbers.add(digit);
            digits *= 10;
            divisor *= 10;
        }

        numbers.add(originalX / digits);

        ArrayList<Integer> reversedNumbers = new ArrayList<>(numbers);
        Collections.reverse(reversedNumbers);

        return numbers.equals(reversedNumbers);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int target = 2143534532;
        boolean isPalindrome = solution.isPalindrome(target);

        System.out.println("Is the number a palindrome? " + isPalindrome);
    }
}
