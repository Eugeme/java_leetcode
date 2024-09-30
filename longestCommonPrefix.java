//Write a function to find the longest common prefix string amongst an array of strings.


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return ""; // Return empty string for edge cases
        }

        // Array to store the common prefix
        StringBuilder prefix = new StringBuilder();

        // Find the length of the shortest word, as we can't check beyond that
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }

        // Iterate over each character index
        for (int i = 0; i < minLength; i++) {
            // Take the character from the first word as the reference
            char currentChar = strs[0].charAt(i);

            // Check if this character matches in all other words
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != currentChar) {
                    // If characters don't match, break and return the prefix
                    return prefix.toString();
                }
            }

            // If all characters match, add the current character to the prefix
            prefix.append(currentChar);
        }

        // Return the common prefix
        return prefix.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"flower", "flow", "flight"};
        String result = solution.longestCommonPrefix(words);
        System.out.println("Longest common prefix: " + result);
    }
}
