package com.example.assignment2.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment2.pojo.ArrayInput;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Assignment2")
@RestController
@RequestMapping("/assignment2/api")
public class AssignmentController {
	@GetMapping(path = "/isPrime/{value}")
	public int isPrime(@PathVariable int value) {
		if (value == 0 || value == 1) {
			return 1;
		} else {
			for (int i = 2; i <= value / 2; i++) {
				if ((value % i) == 0) {
					return 0;
				}
			}
		}
		return 1;
	}

	@GetMapping(path = "/is_palindrome/{number}")
	public String is_palindrome(@PathVariable int number) {
		int temp = number;
		int sum = 0;
		while (number > 0) {
			sum = (sum * 10) + number % 10;
			number = number / 10;
		}
		if (temp == sum)
			return "Yes";
		else
			return "No";
	}

	@GetMapping(path = "/factorial/{num}")
	public long factorial(@PathVariable int num) {
		long fact = 1;
		if (num == 0 || num == 1)
			return 1;
		else {
			for (int i = 1; i <= num; i++) {
				fact = fact * i;
			}
		}
		return fact;
	}

	@GetMapping(path = "/isPalindrome/{str}")
	public int isPalindrome(@PathVariable String str) {
		String temp = str.toLowerCase();
		String rev = "";
		for (int i = (str.length() - 1); i >= 0; i--) {
			rev = rev + temp.charAt(i);
		}
		if (temp.equals(rev))
			return 1;
		else
			return 0;
	}

	@GetMapping(path = "/fibonacci/{n}")
	public long getNthFibonacci(@PathVariable int n) {
		long n1 = 0;
		long n2 = 1;
		long n3 = 0;
		for (int i = 2; i < n; i++) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		return n3;
	}

	@GetMapping(path = "/fibo/{term}")
	public List<Integer> getFibonacci(@PathVariable int term) {
		int n1 = 0;
		int n2 = 1;
		int n3 = 0;
		List<Integer> fibonacciList = new ArrayList<>();
		fibonacciList.add(n1);
		fibonacciList.add(n2);
		while (n3 < term) {
			n3 = n1 + n2;
			fibonacciList.add(n3);
			n1 = n2;
			n2 = n3;
		}
		return fibonacciList;
	}

	@GetMapping(path = "/diff/{amount}")
	public int findDiff(@PathVariable int amount) {
		int temp=0;
		int num=amount;
		while(amount > 0) {
			if(amount%10==9) {
				temp=temp*10+6;
			}else if(amount%10==6) {
				temp=temp*10+9;
			}else {
				temp=temp*10+amount%10;
			}
			amount=amount/10;
			
		}
		return reverseInt(temp)-num;

	}
	private int reverseInt(int amount) {
		int sum=0;
		while(amount >0 ) {
			sum=sum*10+amount%10;
			amount=amount/10;
		}
		return sum;
	}

	@PostMapping("/findAllSubsets")
	public List<List<Integer>> findAllSubsets(@RequestBody ArrayInput arrayInput) {

		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		int[] nums = arrayInput.getArr();
		for (int num : nums) {
			int n = res.size();
			for (int j = 0; j < n; j++) {
				List<Integer> temp = new ArrayList<>(res.get(j));
				temp.add(num);
				temp = temp.stream().sorted().collect(Collectors.toList());
				res.add(temp);
			}
		}

		res = res.stream().distinct().collect(Collectors.toList());
		res.sort((x, y) -> {
			for (int i = 0; i < Math.min(x.size(), y.size()); i++) {
				if (x.get(i) != y.get(i)) {
					return x.get(i) - y.get(i);
				}
			}
			return x.size() - y.size();
		});

		return res;
	}

	@PostMapping("/countSubsets")
	public int countSubsets(@RequestBody ArrayInput arrayInput) {
		HashSet<Integer> us = new HashSet<>();
		int even_count = 0;
		int[] arr = arrayInput.getArr();
		int n = arr.length;
		for (int i = 0; i < n; i++)
			if (arr[i] % 2 == 0)
				us.add(arr[i]);
		even_count = us.size();
		return (int) (Math.pow(2, even_count) - 1);
	}

	@PostMapping("/calculate_Area")
	public int calculate_Area(@RequestBody ArrayList<ArrayList<Integer>> arrayInput) {
		ArrayList<Integer> arr = new ArrayList<>();
		int temp = 1;
		for (int i = 0; i < arrayInput.size(); i++) {
			arr = arrayInput.get(i);
			int result = arr.stream().reduce(1, (a, b) -> a * b).intValue();
			if (result > temp) {
				temp = result;
			}

		}
		return temp;
	}

	@PostMapping("/immediateSmaller")
	public int[] immediateSmaller(@RequestBody int[] arr) {
		// for(int i = 0, j = i + 1;
		int i = 0;
		int j = i + 1;
		int n = arr.length;
		while (i < n - 1) {
			if (arr[i] > arr[j])
				arr[i] = arr[j];
			else
				arr[i] = -1;
			i++;
			j++;
		}
		arr[j - 1] = -1;
		return arr;
	}

	@PostMapping("/zigZag")
	public int[] zigZag(@RequestBody int[] arr) {
		boolean flag = true;
		int temp = 0;
		for (int i = 0; i <= arr.length - 2; i++) {
			if (flag) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			} else {
				if (arr[i] < arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			if (flag == true)
				flag = false;
			else
				flag = true;
		}
		return arr;
	}

	@PostMapping("/thirdLargest")
	public int thirdLargest(@RequestBody int[] arr) {
		int temp;
		int size = arr.length;
		if (size < 3) {
			return -1;
		}
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr[size - 3];
	}

	@PostMapping("/minAnd2ndMin")
	public Vector<Integer> minAnd2ndMin(@RequestBody ArrayList<Integer> arrList) {
		Set<Integer> resultSet = new HashSet<>(arrList);
		ArrayList<Integer> resultList = new ArrayList<>(resultSet);
		Collections.sort(resultList);
		int size = resultList.size();
		Vector<Integer> result = new Vector<>();
		if (size < 2) {
			result.add(-1);
			result.add(-1);
		} else if (size == 2) {
			result.add(resultList.get(0));
			result.add(-1);
		} else {
			result.add(resultList.get(0));
			result.add(resultList.get(1));
		}

		return result;
	}

	@RequestMapping(value = "/remAnagram", method = RequestMethod.POST)
	public int remAnagram(String s1, String s2) {
		boolean[] visited = new boolean[50];
		boolean isAnagram = false;

		int len1 = s1.length();
		int len2 = s2.length();
		if (len1 == len2)
			return 0;
		if (len1 > len2) {
			for (int i = 0; i < len2; i++) {
				isAnagram = false;
				for (int j = 0; j < len1; j++) {
					if (s1.charAt(j) == s2.charAt(i) && !visited[j]) {
						isAnagram = true;
						visited[j] = true;
						break;
					}
				}
				if (!isAnagram) {
					return 0;
				}
			}
			return len1 - len2;
		} else {
			for (int i = 0; i < len1; i++) {
				isAnagram = false;
				for (int j = 0; j < len2; j++) {
					if (s2.charAt(j) == s1.charAt(i) && !visited[j]) {
						isAnagram = true;
						visited[j] = true;
						break;
					}
				}
				if (!isAnagram) {
					return 0;
				}
			}
			return len2 - len1;
		}

	}

//16
	@GetMapping("/sieveOfEratosthenes/{n}")
	public List<Integer> sieveOfEratosthenes(@PathVariable int n) {
		boolean[] arrIsPrime = new boolean[n + 1];
		List<Integer> resultList = new ArrayList<>();
		Arrays.fill(arrIsPrime, true);
		for (int i = 2; i * i <= n; i++) {
			if (arrIsPrime[i]) {
				for (int j = 2 * i; j <= n; j = j + i) {
					arrIsPrime[j] = false;
				}
			}
		}
		for (int i = 2; i <= n; i++) {
			if (arrIsPrime[i] == true) {
				resultList.add(i);
			}
		}
		return resultList;
	}

//17 subsequence= one string should be in another string also in same order of characters.
	@RequestMapping(value = "/isSubSequence", method = RequestMethod.POST)
	public boolean isSubSequence(String a, String b) {
		int i = 0;
		int j = 0;
		if (a.isBlank()) {
			return true;
		}
		if (b.isBlank()) {
			return false;
		}
		if (a.length() <= b.length()) {
			while (i < a.length() && j < b.length()) {
				if (a.charAt(i) == b.charAt(j)) {
					i++;
					j++;
				} else {
					j++;
				}
			}
			if (i == a.length())
				return true;
			else
				return false;
		} else
			return false;

	}

//18
	@RequestMapping(value = "/occurrencesOfNum", method = RequestMethod.POST)
	public List<Integer> arrayInput(int num, ArrayInput arrayInput) {
		List<Integer> resultList = new ArrayList<>();
		int[] numArr = arrayInput.getArr();
		for (int i = 0; i < numArr.length; i++) {
			if (num == numArr[i]) {
				resultList.add(i);
			}
		}
		if (resultList.size() == 0 || resultList.size() == 1) {
			resultList.add(-1);
		} else if (resultList.size() == 2) {
			return resultList;
		} else {
			List<Integer> result = new ArrayList<>();
			result.add(resultList.get(0));
			result.add(resultList.get(resultList.size() - 1));
			return result;
		}
		return resultList;
	}

//19
	@RequestMapping(value = "/mergeString", method = RequestMethod.POST)
	public String merge(String s1, String s2) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s1.length() || i < s2.length(); i++) {
			if (i < s1.length())
				result.append(s1.charAt(i));
			if (i < s2.length())
				result.append(s2.charAt(i));
		}
		return result.toString();
	}

//20
	@GetMapping("/isGoodOrBadString/{n}")
	public int isGoodOrBad(@PathVariable String n) {
		int vow = 0;
		int con = 0;
		n = n.toLowerCase();
		Set<Character> vowelSet = new HashSet<>();
		vowelSet.add('a');
		vowelSet.add('e');
		vowelSet.add('i');
		vowelSet.add('o');
		vowelSet.add('u');
		if (vowelSet.contains(n.charAt(0)))
			vow++;
		else if (n.charAt(0) != '?')
			con++;
		else {
			con++;
			vow++;
		}
		for (int i = 1; i < n.length(); i++) {
			if (vowelSet.contains(n.charAt(i))) {
				con = 0;
				vow++;
			} else if (n.charAt(i) != '?') {
				vow = 0;
				con++;
			} else {
				con++;
				vow++;
			}
			if (vow > 5)
				return 0;
			if (con > 3)
				return 0;
		}
		return 1;

	}

//21
	@PostMapping("/isFrequencyUnique")
	public boolean isFrequencyUnique(@RequestBody ArrayInput arrayInput) {
		Map<Integer, Integer> numMap = new HashMap<>();
		int[] n = arrayInput.getArr();
		for (int i = 0; i < n.length; i++) {
			if (numMap.containsKey(n[i]))
				numMap.put(n[i], numMap.get(n[i]) + 1);
			else
				numMap.put(n[i], 1);
		}
		List<Integer> valuesList = new ArrayList<>(numMap.values());
		Set<Integer> valuesSet = new HashSet<Integer>(numMap.values());

		if (valuesList.size() == valuesSet.size())
			return true;
		else
			return false;
	}
//22

	@PostMapping("/stockBuySellDay")
	public List<Integer> stockBuySellDay(@RequestBody ArrayInput arrayInput) {
		int[] arr = arrayInput.getArr();
		List<Integer> result = new ArrayList<>();
		int sellDay = 0, buyDay = 0;
		int maxProfit = 0;
		int minDay = arr[0];
		for (int i = 0; i < arr.length; i++) {
			minDay = Math.min(minDay, arr[i]);
			if (minDay == arr[i])
				buyDay = i;
			int profit = arr[i] - minDay;
			maxProfit = Math.max(maxProfit, profit);
			if (maxProfit == profit) {
				sellDay = i;
			}

		}
		if (maxProfit == 0) {
			return result;
		}
		result.add(buyDay);
		result.add(sellDay);
		return result;
	}

//23
	@PostMapping("/getMaxProfitInStock")
	public int getMaxProfitInStock(@RequestBody ArrayInput arrayInput) {
		int[] arr = arrayInput.getArr();
		int maxProfit = 0;
		int minDay = arr[0];
		for (int i = 0; i < arr.length; i++) {
			minDay = Math.min(minDay, arr[i]);
			int profit = arr[i] - minDay;
			maxProfit = Math.max(maxProfit, profit);
		}
		return maxProfit;
	}

//24
	@GetMapping("/addMinChar/{s}")
	public int addMinChar(@PathVariable String s) {
		int cnt = 0;
		int flag = 0;

		while (s.length() > 0) {
			if (ispalindrome(s)) {
				flag = 1;
				break;
			} else {
				cnt++;
				s = s.substring(0, s.length() - 1);
			}
		}
		if (flag == 1)
			return cnt;
		else
			return 0;
	}

	private boolean ispalindrome(String s) {
		int l = s.length();

		for (int i = 0, j = l - 1; i <= j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

//25
	@PostMapping("/missingNoInArray")
	public int missingNoInArray(@RequestBody ArrayInput arr) {
		int result = 0;
		int[] a = arr.getArr();
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] != i + 1) {
				result = i + 1;
				break;
			}
		}
		return result;
	}

//26
	@PostMapping("/kthSmallest")
	public int kthSmallest(int k, ArrayInput arrayInput) {
		int arr[] = arrayInput.getArr();
		if (k >= arr.length)
			return 0;

		Arrays.sort(arr);
		return arr[k - 1];

	}

//27
	@PostMapping("/getEquilibriumPoint")
	public int getEquilibriumPoint(ArrayInput arrayInput) {
		int arr[] = arrayInput.getArr();
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < arr.length; i++)
			sum1 = sum1 + arr[i];
		for (int j = 0; j < arr.length; j++) {
			sum1 = sum1 - arr[j];
			if (sum1 == sum2) {
				return (j + 1);
			}
			sum2 = sum2 + arr[j];
		}
		return -1;
	}

//28
	@PostMapping("/print2largest")
	public int print2largest(ArrayInput arrayInput) {
		int[] arr = arrayInput.getArr();
		int size = arr.length;
		Arrays.sort(arr);
		int largest = arr[size - 1];
		for (int i = size - 1; i >= 0; i--) {
			if (largest != arr[i]) {
				largest = arr[i];
				break;
			}
		}
		return largest;
	}

//29
	@PostMapping("/getPairsCount")
	public int getPairsCount(int k, ArrayInput arrayInput) {
		int count = 0;
		int arr[] = arrayInput.getArr();
		for (int i = 0; i < arr.length; i++)
			for (int j = i + 1; j < arr.length; j++)
				if ((arr[i] + arr[j]) == k)
					count++;
		return count;
	}

//30
	@PostMapping("/maxProduct")
	public int maxProduct(ArrayInput arrayInput) {
		int[] arr = arrayInput.getArr();
		int result = arr[0];
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int mul = arr[i];
			for (int j = i + 1; j < n; j++) {
				result = Math.max(result, mul);
				mul *= arr[j];
			}
			result = Math.max(result, mul);
		}
		return result;
	}
}
