package com.example.assignment2.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import com.example.assignment2.pojo.ArrayInput;

@RunWith(PowerMockRunner.class)
public class AssignmentControllerTest {
	@InjectMocks
	AssignmentController assignmentController;

	@Test
	public void isPrime() {
		assertEquals(1, assignmentController.isPrime(1));
	}

	@Test
	public void isPrimeTest() {
		assertEquals(0, assignmentController.isPrime(20));
	}

	@Test
	public void is_palindrome() {
		assertEquals("No", assignmentController.is_palindrome(20));
	}

	@Test
	public void is_palindromeTest() {
		assertEquals("Yes", assignmentController.is_palindrome(22));
	}

	@Test
	public void factorial() {
		assertEquals(1, assignmentController.factorial(0));
	}

	@Test
	public void factorialTest() {
		assertEquals(120, assignmentController.factorial(5));
	}

	@Test
	public void isPalindrome() {
		assertEquals(0, assignmentController.isPalindrome("abb"));
	}

	@Test
	public void isPalindromeTest() {
		assertEquals(1, assignmentController.isPalindrome("madam"));
	}

	@Test
	public void getNthFibonacci() {
		assertEquals(5, assignmentController.getNthFibonacci(6));
	}

	@Test
	public void getFibonacci() {
		assertNotNull(assignmentController.getFibonacci(6));
	}

	@Test
	public void findDiff() {
		assertNotNull(assignmentController.findDiff(26));
	}

	@Test
	public void findAllSubsets() {
		ArrayInput arrayInput = new ArrayInput();
		int[] arr = { 1, 2, 3, 4 };
		arrayInput.setArr(arr);
		assertNotNull(assignmentController.findAllSubsets(arrayInput));
	}

	@Test
	public void countSubsets() {
		ArrayInput arrayInput = new ArrayInput();
		int[] arr = { 1, 2, 3, 4 };
		arrayInput.setArr(arr);
		assertNotNull(assignmentController.countSubsets(arrayInput));
	}

	@Test
	public void calculate_Area() {
		ArrayList<Integer> arrList1 = new ArrayList<>();
		arrList1.add(1);
		arrList1.add(2);
		ArrayList<Integer> arrList2 = new ArrayList<>();
		arrList2.add(5);
		arrList2.add(6);
		ArrayList<Integer> arrList3 = new ArrayList<>();
		arrList3.add(8);
		arrList3.add(9);
		ArrayList<ArrayList<Integer>> arrayInput = new ArrayList<>();
		arrayInput.add(arrList3);
		arrayInput.add(arrList2);
		arrayInput.add(arrList1);
		assertEquals(72, assignmentController.calculate_Area(arrayInput));
	}

	@Test
	public void immediateSmaller() {
		int[] arr = { 1, 2, 3, 4 };
		assertNotNull(assignmentController.immediateSmaller(arr));
	}

	@Test
	public void zigZag() {
		int[] arr = { 1, 2, 3, 4 };
		assertNotNull(assignmentController.zigZag(arr));
	}

	@Test
	public void thirdLargest() {
		int[] arr = { 1, 2, 3, 4 };
		assertNotNull(assignmentController.thirdLargest(arr));
	}

	@Test
	public void minAnd2ndMin() {
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.add(12);
		arrList.add(2);
		arrList.add(2);
		arrList.add(3);
		arrList.add(1);
		assertNotNull(assignmentController.minAnd2ndMin(arrList));
	}

	@Test
	public void remAnagram() {
		assertNotNull(assignmentController.remAnagram("aab", "bbba"));
	}

	@Test
	public void remAnagramTest() {
		assertNotNull(assignmentController.remAnagram("aabaabb", "bbba"));
	}

	@Test
	public void sieveOfEratosthenes() {
		assertNotNull(assignmentController.sieveOfEratosthenes(4));
	}

	@Test
	public void isSubSequence() {
		assertFalse(assignmentController.isSubSequence("aba", "baab"));
	}

	@Test
	public void arrayInput() {
		ArrayInput arrayInput = new ArrayInput();
		int[] arr = { 1, 2, 3, 4, 2 };
		arrayInput.setArr(arr);
		assertNotNull(assignmentController.arrayInput(2, arrayInput));
	}

	@Test
	public void arrayInputTest() {
		ArrayInput arrayInput = new ArrayInput();
		int[] arr = { 1, 2, 3, 4, 2, 4, 4, 3 };
		arrayInput.setArr(arr);
		assertNotNull(assignmentController.arrayInput(4, arrayInput));
	}

	@Test
	public void merge() {
		assertNotNull(assignmentController.merge("aab", "bbba"));
	}

	@Test
	public void isGoodOrBad() {
		assertNotNull(assignmentController.isGoodOrBad("bbba"));
	}

	@Test
	public void isFrequencyUnique() {
		ArrayInput arrayInput = new ArrayInput();
		int[] arr = { 1, 2, 3, 4, 4, 2, 2, 1 };
		arrayInput.setArr(arr);
		assertNotNull(assignmentController.isFrequencyUnique(arrayInput));
	}

	@Test
	public void stockBuySellDay() {
		ArrayInput arrayInput = new ArrayInput();
		int[] arr = { 1, 2, 3, 4, 4, 2, 2, 1 };
		arrayInput.setArr(arr);
		assertNotNull(assignmentController.stockBuySellDay(arrayInput));
	}

	@Test
	public void getMaxProfitInStock() {
		ArrayInput arrayInput = new ArrayInput();
		int[] arr = { 1, 2, 3, 4, 4, 2, 2, 1 };
		arrayInput.setArr(arr);
		assertNotNull(assignmentController.getMaxProfitInStock(arrayInput));
	}

	@Test
	public void addMinChar() {
		assertEquals(1, assignmentController.addMinChar("abaa"));
	}

	@Test
	public void missingNoInArray() {
		ArrayInput arrayInput = new ArrayInput();
		int[] arr = { 1, 2, 3, 4, 2, 4, 4, 3 };
		arrayInput.setArr(arr);
		assertNotNull(assignmentController.missingNoInArray(arrayInput));
	}

	@Test
	public void kthSmallest() {
		ArrayInput arrayInput = new ArrayInput();
		int[] arr = { 1, 2, 3, 4, 2, 4, 4, 3 };
		arrayInput.setArr(arr);
		assertNotNull(assignmentController.kthSmallest(4, arrayInput));
	}

	@Test
	public void getEquilibriumPoint() {
		ArrayInput arrayInput = new ArrayInput();
		int[] arr = { 1, 2, 3, 3, 4, 2 };
		arrayInput.setArr(arr);
		assertNotNull(assignmentController.getEquilibriumPoint(arrayInput));
	}

	@Test
	public void print2largest() {
		ArrayInput arrayInput = new ArrayInput();
		int[] arr = { 1, 2, 3, 3, 4, 2 };
		arrayInput.setArr(arr);
		assertNotNull(assignmentController.print2largest(arrayInput));
	}

	@Test
	public void getPairsCount() {
		ArrayInput arrayInput = new ArrayInput();
		int[] arr = { 1, 2, 3, 4, 2, 4, 4, 3 };
		arrayInput.setArr(arr);
		assertNotNull(assignmentController.getPairsCount(4, arrayInput));
	}

	@Test
	public void maxProduct() {
		ArrayInput arrayInput = new ArrayInput();
		int[] arr = { 1, 2, 3, 3, 4, 2 };
		arrayInput.setArr(arr);
		assertNotNull(assignmentController.maxProduct(arrayInput));
	}

}
