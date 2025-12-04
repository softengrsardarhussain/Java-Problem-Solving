// Import ArrayList class from java.util package for dynamic array functionality

import java.util.ArrayList;

// Main class definition
public class AnagramPermutation {
	// Main method - entry point of the program
	public static void main(String[] args) {
		// Declare and initialize first string to check
		String a = "apple";
		// Declare and initialize second string to check (potential anagram)
		String b = "alpep";
		
		// String to store characters found in both strings
		String results = "";
		// ArrayList to track which positions in string b have been matched
		ArrayList<Integer> indexes = new ArrayList<>();
		
		// Outer loop: iterate through each character of string a
		for (int i = 0; i < a.length(); i++) {
			// Inner loop: iterate through each character of string b
			for (int j = 0; j < b.length(); j++) {
				// Check if current position in b has already been matched
				if (!indexes.isEmpty() && indexes.contains(j)) {
					continue;  // Skip this position if already used
				}
				
				// Check if characters at current positions match
				if (a.charAt(i)==b.charAt(j)) {
					// Add matched character to results string
					results = results + b.charAt(j);
					// Add position to indexes list to mark as used
					indexes.add(j);
					// Debug output: show current results and position
					System.out.println(results + "   " + j);
					break;  // Exit inner loop after finding a match
				}
			}
		}
		
		// Check if all characters were matched in correct order
		if (a.equals(results)) {
			// Strings are anagrams
			System.out.println("a is anagram of b");
		} else {
			// Strings are not anagrams
			System.out.println("a is not anagram of b");
		}
	}
}