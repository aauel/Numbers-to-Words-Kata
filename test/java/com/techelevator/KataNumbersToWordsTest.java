package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataNumbersToWordsTest {
	
	private KataNumbersToWords numbers;
	
	@Before
	public void setup() {
		numbers = new KataNumbersToWords();
	}
	@Test
	public void test_999999() {
		Assert.assertEquals("nine hundred and ninety-nine thousand and nine hundred and ninety-nine", numbers.convertNumToWord(999999));
	}
	@Test
	public void test_513492() {
		Assert.assertEquals("five hundred and thirteen thousand and four hundred and ninety-two", numbers.convertNumToWord(513492));
	}
	@Test
	public void test_500000() {
		Assert.assertEquals("five hundred thousand", numbers.convertNumToWord(500000));
	}
	@Test
	public void test_87654() {
		Assert.assertEquals("eighty-seven thousand and six hundred and fifty-four", numbers.convertNumToWord(87654));
	}	
	@Test
	public void test_12025() {
		Assert.assertEquals("twelve thousand and twenty-five", numbers.convertNumToWord(12025));
	}
	@Test
	public void test_7111() {
		Assert.assertEquals("seven thousand and one hundred and eleven", numbers.convertNumToWord(7111));
	}
	
	@Test
	public void test_1_returns_one() {
		Assert.assertEquals("one", numbers.convertNumToWord(1));
	}
	
	@Test 
	public void test_2_returns_two() {
		Assert.assertEquals("two", numbers.convertNumToWord(2));
	}
	@Test 
	public void test_3_returns_three() {
		Assert.assertEquals("three", numbers.convertNumToWord(3));
	}
	@Test 
	public void test_10_returns_ten() {
		Assert.assertEquals("ten", numbers.convertNumToWord(10));
	}
	@Test 
	public void test_14_returns_fourteen() {
		Assert.assertEquals("fourteen", numbers.convertNumToWord(14));
	}
	@Test
	public void test_25_returns_twenty_five() {
		Assert.assertEquals("twenty-five", numbers.convertNumToWord(25));
		
	}
	@Test
	public void test_135_returns_expected_value() {
		Assert.assertEquals("one hundred and thirty-five", numbers.convertNumToWord(135));
	}
	
	@Test
	public void test_400_returns_expected_value() {
		Assert.assertEquals("four hundred", numbers.convertNumToWord(400));
	}
	
	@Test
	public void test_1000_returns_expected_value() {
		Assert.assertEquals("one thousand", numbers.convertNumToWord(1000));
	}
	@Test
	public void test_1450_returns_expected_value() {
		Assert.assertEquals("one thousand and four hundred and fifty", numbers.convertNumToWord(1450));
	}
	@Test
	public void test_20000_returns_expected_value() {
		Assert.assertEquals("twenty-two thousand and six hundred and fifty-two", numbers.convertNumToWord(22652));
	}
	
}
