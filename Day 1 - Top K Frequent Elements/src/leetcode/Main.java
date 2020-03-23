package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import mysolution.utils.ArrayUtils;

public class Main {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter array size: ");
		int arraySize = keyboard.nextInt();
		
		System.out.print("Enter amount of elements to display: ");
		int k = keyboard.nextInt();
		
		int[] nums = ArrayUtils.buildRandomArray(arraySize);
		System.out.println("\nArray created:\n" + Arrays.toString(nums));
		
		
		// Solution from Leetcode Challenge thread
		// Use a hashmap to store keys as elements and values as frequencies
		Map<Integer, Integer> frequenciesMap = new HashMap<>();
		for(int n : nums) {
			if(frequenciesMap.containsKey(n)) {
				int value = frequenciesMap.get(n) + 1;
				frequenciesMap.put(n, value);
			}
			else {
				frequenciesMap.put(n, 1);
			}
		}
		
		
		// Use TreeMap to store the frequency with respective elements
		TreeMap<Integer, List<Integer>> frequencyTreeMap = new TreeMap<>();
		for(int n : frequenciesMap.keySet()) {
			int frequency = frequenciesMap.get(n);
			
			if(!frequencyTreeMap.containsKey(frequency)) {
				frequencyTreeMap.put(frequency, new ArrayList<Integer>());
			}
			frequencyTreeMap.get(frequency).add(n);
		}
		
		
		// Show the result
		List<Integer> result = new ArrayList<>();
		while(result.size() < k) {
			// This line returns the value associated with the greatest key of the tree map
			Map.Entry<Integer, List<Integer>> entry = frequencyTreeMap.pollLastEntry();
			result.addAll(entry.getValue());
		}
		
		System.out.println("\n" + k + " most frequent elements in the array:\n" + result);

	}

}
