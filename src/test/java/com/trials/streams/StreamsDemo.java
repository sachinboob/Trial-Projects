package com.trials.streams;

import java.util.Arrays;
import java.util.List;

public class StreamsDemo {

	public static void main(String[] args) {

		String[] stringArray = { "N40", "N36", "B12", "B6", "G59", "G53", "G50", "I17", "I29", "O71" };
		List<String> someBingoNumbers = Arrays.asList(stringArray);

		someBingoNumbers.stream()
				.map(String::toUpperCase)
				.filter((String str) -> str.startsWith("G"))
				.sorted()
				.forEach(System.out::println);
	}
}