import java.util.*;

public class LongestSubstring {
	
	// Main method to test the solution
	public static void main(String[] args) {
		// Problem: Longest Substring Without Repeating Characters
		// Given a string s, find the length of the
		// longest substring without duplicate characters.
		
		// Test case 1:
		// Input: s = "defggft"
		// Expected Output: 4
		// Explanation: The longest substring without duplicates is "defg"
		System.out.println(longestSubStringFinder("defggft"));
		
		// Test case 2:
		// Input: s = "abcabccc"
		// Expected Output: 3 (substring "abc")
		System.out.println(longestSubStringFinder("abcabccc"));
	}
	
	// Method to find the longest substring without repeating characters
	static int longestSubStringFinder(String s) {
		// HashSet to track characters in the current sliding window
		HashSet<Character> hashSet = new HashSet<>();
		
		// Variable to store the longest substring found
		String longestSubstring = "";
		
		// Left pointer/index of the sliding window
		int index = 0;
		
		// Iterate through each character in the string
		for (int i = 0; i < s.length(); i++) {
			
			// If current character is already in the HashSet (duplicate found)
			if (!hashSet.isEmpty() && hashSet.contains(s.charAt(i))) {
				
				// Update longestSubstring if current window is longer
				if (longestSubstring.length() < hashSet.size()) {
					longestSubstring = getSubstring(hashSet);
				}
				
				// Move left pointer to remove characters until duplicate is gone
				// This shrinks the window from the left
				while (hashSet.contains(s.charAt(i))) {
					hashSet.remove(s.charAt(index));
					index++; // Move left pointer rightwards
				}
				
				// Add the current character (now unique in the window)
				hashSet.add(s.charAt(i));
			}
			// Current character is not in the HashSet (unique in current window)
			else {
				hashSet.add(s.charAt(i));
			}
			
			// Check again if current window is the longest
			if (longestSubstring.length() < hashSet.size()) {
				longestSubstring = getSubstring(hashSet);
			}
		}
		
		// Output the longest substring found
		System.out.println(longestSubstring);
		
		// Return the length of the longest substring
		return longestSubstring.length();
	}
	
	// Helper method to convert HashSet of characters to a String
	static String getSubstring(HashSet<Character> s) {
		// StringBuilder for efficient string construction
		StringBuilder stringBuilder = new StringBuilder();
		
		// Append each character from HashSet to StringBuilder
		for (char c: s) {
			stringBuilder.append(c);
		}
		
		// Return the constructed string
		return stringBuilder.toString();
	}
	
	// Note about the algorithm:
	// This implements a sliding window approach with two pointers:
	// - index (left pointer)
	// - i (right pointer, from the for loop)
	// Time complexity: O(n) where n is string length
	// Space complexity: O(min(n, m)) where m is character set size
	
	// Limitation: The current implementation has an issue:
	// The getSubstring method doesn't preserve character order from the original string.
	// The substring "defg" might be returned as a different permutation.
	// To fix this, we should store the actual substring or its indices instead of using HashSet.
}