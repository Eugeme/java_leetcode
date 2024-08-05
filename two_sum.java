// https://leetcode.com/problems/two-sum/description/
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.


class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int x = i+1; x < nums.length; x++) {
                int sum = nums[i] + nums[x];
                if (sum == target){
                    return new int[] {i, x};
                }
            }
        }

        return nums;
    }
}


public class Main {
    public static void main(String[] args) {
    Solution solution = new Solution();

    // Test case
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int[] result = solution.twoSum(nums, target);

    // Output the result
    if (result.length == 2) {
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    } else {
        System.out.println("No solution found.");
    }
    }
}
