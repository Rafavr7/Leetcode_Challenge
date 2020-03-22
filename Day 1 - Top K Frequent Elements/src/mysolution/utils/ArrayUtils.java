package mysolution.utils;

import java.util.Random;

public class ArrayUtils {
	
	/**
	 * Returns an unsorted array containing <b>arraySize</b> random numbers.
	 * The random numbers generated range from 1 to <b>arraySize</b> (inclusive).
	 * Throws IllegalArgumentException if parameter is not greater than 0 (zero).
	 */
	public static int[] buildRandomArray(int arraySize) {
		if(arraySize <= 0) {
			throw new IllegalArgumentException("Parameter must be greater than zero!");
		}
		
		int[] nums = new int[arraySize];
		Random rng = new Random();
		
		for(int x = 0; x < arraySize; x++) {
			int randomNumber = rng.nextInt(arraySize) + 1;
			nums[x] = randomNumber;
		}
		
		return nums;
	}
	
	
	public static void printArrayTableForm(int[] nums, int numbersPerRow) {
		if(numbersPerRow <= 0) {
			throw new IllegalArgumentException("Parameter 'numbersPerRow' must be greater than zero!");
		}
		
		// Discover how many rows it will be necessary to print
		int rowsToPrint = nums.length / numbersPerRow;
		if(nums.length % numbersPerRow != 0) {
			rowsToPrint += 1;
		}
		
		int printedElements = 0;
		for(int x = 0; x < rowsToPrint; x++) {
			for(int y = 0; y < numbersPerRow; y++) {
				int posToPrint = x * numbersPerRow + y;
				System.out.print(nums[posToPrint] + "\t");
				
				printedElements++;
				if(printedElements == nums.length) {
					return;
				}
			}
			
			System.out.println();
		}
	}

}
