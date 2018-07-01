package var2.task1;

import java.util.ArrayList;
import java.util.List;

public class Str {
	private List<String> list;
	private double average;

	public Str() {
		list = new ArrayList<>();
		average = 0;
	}

	public void add(String string) {
		list.add(string);
		calculateAverage();
	}

	private void calculateAverage() {
		int commonLength = 0;
		for (String s : list) {
			commonLength += s.length();
		}
		average = ((double) commonLength) / list.size();
	}

	public void print(){
		System.out.println("Average: " + average);
		for (String s : list) {
			if (s.length() < average){
				System.out.println(s + "\nLength: " + s.length());
			}
		}
	}
}
