import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

// Class definition for checking duplicate elements in an array
public class ContainDuplicate {
	
	// Main method - entry point of the program
	public static void main(String[] args) {
		// Declare and initialize an array of integers
		int[] num = {1, 2, 3, 4, 5};
		
		// Call the three different methods and print their results
		System.out.println("i am hashset   " + usingHashset(num));  // Method 1: Using HashSet
		System.out.println("i am Sorting   " + usingSortingFirst(num));  // Method 2: Using Sorting
		System.out.println("i am Stream    " + usingJavaStreams(num));  // Method 3: Using Java Streams
	}
	
	// Method 1: Check for duplicates using HashSet
	static boolean usingHashset(int[] nums) {
		// Create a HashSet to store unique elements
		HashSet<Integer> set = new HashSet<>();
		
		// Iterate through each element in the array
		for (int n : nums) {
			// If set.add(n) returns false, element already exists in set
			if (!set.add(n)) {
				return true;  // Duplicate found, return true
			}
		}
		return false;  // No duplicates found, return false
	}
	
	// Method 2: Check for duplicates by sorting the array first
	static boolean usingSortingFirst(int[] nums) {
		// Sort the array in ascending order
		Arrays.sort(nums);
		
		// Iterate through the sorted array
		for (int i = 0; i < nums.length - 1; i++) {
			// Check if current element equals the next element
			if (nums[i]==nums[i + 1]) {
				return true;  // Duplicate found, return true
			}
		}
		return false;  // No duplicates found, return false
	}
	
	// Method 3: Check for duplicates using Java Streams
	static boolean usingJavaStreams(int[] nums) {
		// Convert array to stream, box to Integer, collect to Set, compare sizes
		return Arrays.stream(nums)          // Create stream from array
				.boxed()                    // Convert int to Integer (autoboxing)
				.collect(Collectors.toSet()) // Collect to Set (removes duplicates)
				.size() < nums.length;      // If Set size < array length, duplicates exist
	}
	
}
