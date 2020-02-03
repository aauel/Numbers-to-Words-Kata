package com.techelevator;

import java.util.HashMap;
import java.util.Map;


public class KataNumbersToWords {
	
	// Test Cases:
	// 999,999 -> nine hundred and ninety-nine thousand and nine-hundred and ninety-nine
	// 513,492 -> five hundred and thirteen thousand and four hundred and ninety-two
	// 500,000 -> five hundred thousand
	//  87,654 -> eighty-seven thousand and six hundred and fifty-four
	//  12,025 -> twelve thousand and twenty-five
	//   7,111 -> seven thousand and one hundred and eleven

	private static Map<Integer, String> NUMBER_TO_WORD_MAP = new HashMap<Integer, String>();
	static {
		NUMBER_TO_WORD_MAP.put(90, "ninety");
		NUMBER_TO_WORD_MAP.put(80, "eighty");
		NUMBER_TO_WORD_MAP.put(70, "seventy");
		NUMBER_TO_WORD_MAP.put(60, "sixty");
		NUMBER_TO_WORD_MAP.put(50, "fifty");
		NUMBER_TO_WORD_MAP.put(40, "forty");
		NUMBER_TO_WORD_MAP.put(30, "thirty");
		NUMBER_TO_WORD_MAP.put(20, "twenty");
		NUMBER_TO_WORD_MAP.put(19, "nineteen");
		NUMBER_TO_WORD_MAP.put(18, "eighteen");
		NUMBER_TO_WORD_MAP.put(17, "seventeen");
		NUMBER_TO_WORD_MAP.put(16, "sixteen");
		NUMBER_TO_WORD_MAP.put(15, "fifteen");
		NUMBER_TO_WORD_MAP.put(14, "fourteen");
		NUMBER_TO_WORD_MAP.put(13, "thirteen");
		NUMBER_TO_WORD_MAP.put(12, "twelve");
		NUMBER_TO_WORD_MAP.put(11, "eleven");
		NUMBER_TO_WORD_MAP.put(10, "ten");
		NUMBER_TO_WORD_MAP.put(9, "nine");
		NUMBER_TO_WORD_MAP.put(8, "eight");
		NUMBER_TO_WORD_MAP.put(7, "seven");
		NUMBER_TO_WORD_MAP.put(6, "six");
		NUMBER_TO_WORD_MAP.put(5, "five");
		NUMBER_TO_WORD_MAP.put(4, "four");
		NUMBER_TO_WORD_MAP.put(3, "three");
		NUMBER_TO_WORD_MAP.put(2, "two");
		NUMBER_TO_WORD_MAP.put(1, "one");

	}
	
	public String convertNumToWord(int number) {
		
		// get the thousands digits into an int[] and convert to words
		int[] digits = convertNumberTo3DigitsArray(number / 1000);  // 87,654 -> 87 -> [0, 8, 7]
		String thousands = convertThree(digits);
		
		// add " thousand" only if there were digits in the thousands
		if (thousands.length() != 0) thousands += " thousand";  
		
		// get the hundreds digits into an int[] and convert to words
		digits = convertNumberTo3DigitsArray(number % 1000);  // 87,654 -> 654 -> [6, 5, 4]
		String hundreds = convertThree(digits);
		
		// add " and " only if there were digits in both the thousands and hundreds
		// for example, don't add " and " for numbers like 500,000 and 600
		if (thousands.length() != 0 && hundreds.length() != 0) thousands += " and ";
		String wordsCombined = thousands + hundreds;
					
		System.out.println(number + " -> " + wordsCombined);
		return wordsCombined;
	}
	
	private String convertThree(int[] digits) {
		
		String wordsCombined = "";
		int tens = 0;
		
		if (digits[0] != 0) {
			wordsCombined = NUMBER_TO_WORD_MAP.get(digits[0]) + " hundred";
			// 999 -> "nine hundred"
			// 513 -> "five hundred"
			// 500 -> "five hundred"
		}
		
		if (digits[1] == 1) {
			// need to get the 2nd and 3rd digits together to get the teens word
			tens = Integer.parseInt(Integer.toString(digits[1]) + Integer.toString(digits[2]));  // 513,492 -> 13
			if (wordsCombined.length() != 0) wordsCombined += " and ";
			wordsCombined += NUMBER_TO_WORD_MAP.get(tens);
			// 513 -> "five hundred and thirteen"
			//  12 -> "twelve"
			
		} else if (digits[1] != 0) {
			// get the 2nd digit and add "0" onto the end to get the twenty, thirty, etc. words
			tens = Integer.parseInt(Integer.toString(digits[1]) + "0");  // 999,999 -> 90
			if (wordsCombined.length() != 0) wordsCombined += " and ";
			wordsCombined += NUMBER_TO_WORD_MAP.get(tens);
			// 999 -> "nine hundred and ninety"
			// 	87 -> "eighty"
		}
		
		if (digits[1] != 1 && digits[2] != 0) {
			if (wordsCombined.length() != 0) wordsCombined += "-";
			wordsCombined += NUMBER_TO_WORD_MAP.get(digits[2]);
			// 999 -> "nine hundred and ninety-nine"
			// 	87 -> "eighty-seven"
			//   7 -> "seven"
		}
		
		return wordsCombined;	
	}
	
	private int[] convertNumberTo3DigitsArray(int number) {
		
		int[] digits = new int[3];
		
		digits[0] = (number % 1000) / 100;
		digits[1] = (number % 100) / 10;
		digits[2] = (number % 10) / 1;
		
		return digits;
	}

}
