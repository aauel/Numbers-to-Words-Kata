package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataStringCalculatorTest {
	
	private KataStringCalculator calculator;
	
	@Before
	public void setup() {
		calculator = new KataStringCalculator();
	}
	
	@Test
	public void test_empty_string_returns_0 () {
		
		Assert.assertEquals(0, calculator.add(""));
	}
	
	@Test
	public void test_one_returns_1() {
		
		Assert.assertEquals(1, calculator.add("1"));
	}
	@Test
	public void test_1_2_returns_sum() {
		Assert.assertEquals(3, calculator.add("1,2"));
	}

	// Step 2
	@Test
	public void test_more_than_2_digits() {
		Assert.assertEquals(24, calculator.add("5,7,12"));
		Assert.assertEquals(17, calculator.add("6,2,1,8"));		
	}
	
	//Step 3
	@Test
	public void test_1_2_n3_returns_sum() {
		Assert.assertEquals(6, calculator.add("1,2\n3"));
	}
	// Step 4
	@Test
	public void test_example1_returns_sum() {
		Assert.assertEquals(14, calculator.add("3\n5\n2,4"));
	}
	
}
