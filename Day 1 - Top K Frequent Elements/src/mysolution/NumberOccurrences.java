package mysolution;

public class NumberOccurrences implements Comparable<NumberOccurrences> {
	
	private int number;
	private int occurrences;
	
	public NumberOccurrences(int number) {
		this.number = number;
		occurrences = 0;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getOccurrences() {
		return occurrences;
	}
	
	public void addOneOccurrence() {
		occurrences += 1;
	}
	
	@Override
	public int compareTo(NumberOccurrences other) {
		return other.getOccurrences() - this.occurrences;
	}
	
	@Override
	public String toString() {
		return "Number: " + number + "\tOccurrences: " + occurrences;
	}

}
