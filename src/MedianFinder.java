import java.util.Arrays;

public class MedianFinder {
	public static void main(String[] args) {
		// Define two input arrays
		int[] num1 = new int[] {1, 3, 2};
		int[] num2 = new int[] {5, 4, 6};
		
		// Create an array to hold merged elements from both arrays
		int[] mergedArray = new int[num1.length + num2.length];
		
		// Copy elements from num1 into the beginning of mergedArray
		for (int i = 0; i < num1.length; i++) {
			mergedArray[i] = num1[i];
		}
		
		// Copy elements from num2 after the elements from num1
		for (int i = 0; i < num2.length; i++) {
			mergedArray[num1.length + i] = num2[i];
		}
		
		// Sort the merged array in ascending order
		Arrays.sort(mergedArray);
		
		// Check if the merged array has an even number of elements
		if (mergedArray.length % 2 == 0) {
			// For even length: median is average of two middle elements
			int mid = mergedArray.length / 2;            // Index of second middle element
			int midL = mergedArray[mid - 1];            // First middle element
			int midR = mergedArray[mid];                // Second middle element
			double ans = (double) (midL + midR) / 2;    // Calculate average as double
			System.out.println(ans);                    // Print median
		} else {
			// For odd length: median is the middle element
			System.out.println(mergedArray[mergedArray.length / 2]);
		}
	}
}