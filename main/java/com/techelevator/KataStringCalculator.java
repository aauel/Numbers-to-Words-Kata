package com.techelevator;

public class KataStringCalculator {

	public int add(String input) {
		int sum = 0;
		String input2 = input.replaceAll("\n", ",");
		if (input != "") {
			String[] array = input2.split(",");
			for (String s : array) {
				int num = Integer.parseInt(s);
				sum += num;
			}
		}

		return sum;
	}

}
