
public class ReverseInteger {
	// Main method to test the reverse function
	public static void main(String[] args) {
		System.out.println(reverseInt(123)); // Output: 321
	}
	
	// Reverses an integer; returns 0 if reversed value overflows
	static int reverseInt(int n) {
		if (n == 0) return 0; // Handle zero directly
		
		final int iMax = Integer.MAX_VALUE; // Max integer value
		final int iMin = Integer.MIN_VALUE; // Min integer value
		int d = Math.abs(n); // Work with absolute value for reversal
		long r = 0; // Use long to detect overflow
		
		if (n >= iMin || n <= iMax) { // Always true for valid int
			for (int i = d; i > 0; i /= 10) { // Process each digit
				r = r * 10 + (i % 10); // Append next digit
				if ( r > iMax || r < iMin) { // Check overflow
					return 0;
				}
			}
		}
		
		if (n < 0) { // Restore original sign
			return -(int) r;
		}
		return (int) r;
	}
}