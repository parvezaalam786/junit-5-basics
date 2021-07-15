package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MathUtilsTest {
	
	MathUtils mathUtils;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This is before all");
	}

	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}
	
	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up....");
	}

	@Test
	@DisplayName("Testing add method")
	void testAdd() {	
		int expected = 3;
		int actual = mathUtils.add(1, 2);
		assertEquals(expected, actual, "The add method should add two numbers");
	}
	
	@Nested
	@DisplayName("add method")
	class AddTest {
		@Test
		@DisplayName("when adding two positive numbers")
		void testAddPositive() {
			assertEquals(2, mathUtils.add(1, 1), "should return the right sum");
		}
		
		@Test
		@DisplayName("when adding two positive numbers")
		void testAddNegative() {
			assertEquals(-2, mathUtils.add(-1, -1), "Should return the right sum");
		}
	}
	
	@Test
	@DisplayName("multiply method")
	void testMultiply() {
		assertAll(
				() -> assertEquals(4, mathUtils.multiply(2, 2)),
				() -> assertEquals(0, mathUtils.multiply(2, 0)),
				() -> assertEquals(-2, mathUtils.multiply(-1, 2))
				);
	}
	
	@Test
	@EnabledOnOs(OS.LINUX)
	void testDivide() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		
		assertThrows(ArithmeticException.class , () -> mathUtils.divide(1, 0), "Divide by zero should throw");
	}
	
	@Test
	@Disabled
	@DisplayName("TDD method. Should not run")
	void testDisabled() {
		fail("This test should be disabled");
	}
	
	@Test
	void testComputeCircleArea() {
		assertEquals(314.1592653589793
, mathUtils.computeCircleArea(10), "Should return right circle area");
	}
	
	
}
