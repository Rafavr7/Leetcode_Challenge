package mysolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import mysolution.utils.ArrayUtils;

public class Main {
	
	private static int ARRAY_SIZE = 30;
	
	public static void main(String[] args) {
		
		// Get user inputs for array size and number of elements to return
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Input array size: ");
		int arraySize = keyboard.nextInt();
		
		System.out.print("Input number of elements to return: ");
		int numberOfElements = keyboard.nextInt();
		keyboard.close();
		
		// Create unsorted array with random numbers
		int[] nums = ArrayUtils.buildRandomArray(arraySize);
		System.out.println("\nArray Generated:\n" + Arrays.toString(nums));
		
		// Map the occurrences of each element of the array and sort the list in descending order 
		Map<Integer, NumberOccurrences> occurrencesMap = getNumberOccurrencesMap(nums);
		ArrayList<NumberOccurrences> occurrencesList = new ArrayList<>(occurrencesMap.values());
		Collections.sort(occurrencesList);
		
		System.out.println("\nOccurrences of each element of the array (sorted in descending order):");
		for(NumberOccurrences occurrence : occurrencesList) {
			System.out.println(occurrence);
		}
		
		System.out.println("\n\nTop " + numberOfElements + " frequent elements:");
		for(int x = 0; x < numberOfElements; x++) {
			NumberOccurrences number = occurrencesList.get(x);
			System.out.println(number);
		}
		
		
	}
	
	private static Map<Integer, NumberOccurrences> getNumberOccurrencesMap(int[] nums) {
		
		Map<Integer, NumberOccurrences> numberOccurrencesMap = new HashMap<>();
		for(int n : nums) {
			if(numberOccurrencesMap.get(n) == null) {
				numberOccurrencesMap.put(n, new NumberOccurrences(n));
			}
			
			NumberOccurrences occurrences = numberOccurrencesMap.get(n);
			occurrences.addOneOccurrence();
			numberOccurrencesMap.put(n, occurrences);
		}
		
		return numberOccurrencesMap;
	}

}
