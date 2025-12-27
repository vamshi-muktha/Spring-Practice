package com.tcs.AssessmentWeek3;

import java.util.List;

public class Question2 {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
		
		
	}
}
