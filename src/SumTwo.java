import java.util.Arrays;

public class SumTwo {
	// Problem: Given an array of integers nums and an integer target,
	// return indices of the two numbers such that they add up to target.
	// Example: nums[] = {1,2,3,4,5}, target = 8 → returns [2, 4]
	// Constraint: You may not use the same element twice.
	
	public static void main(String[] args) {
		int[] nums = new int[] {6,7,8,9,10}; // Input array
		int target = 19; // Target sum
		System.out.println(Arrays.toString(getIndexes(nums, target))); // Print result
	}
	
	static int[] getIndexes(int[] nums, int target) {
		int[] ans = new int[0]; // Default empty array if no solution found
		
		// Brute force approach: check all possible pairs
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				// Check if sum equals target and indices are different
				if (nums[i] + nums[j] == target && i != j) {
					System.out.println(nums[i] + " , " + nums[j]); // Debug print
					return ans = new int[] {i, j}; // Return solution indices
				}
			}
		}
		return ans; // Return empty array if no solution found
	}
}
