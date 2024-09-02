// https://leetcode.com/problems/palindrome-number/description/
// Given an integer x, return true if x is a palindrome, and false otherwise.

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversedHalf = 0;
        
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf / 10;
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
