package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Anagram {

	// Complete the makeAnagram function below.
	static int makeAnagram(String a, String b) {

		Map<String, Integer> aMap = new HashMap<>();
		Map<String, Integer> bMap = new HashMap<>();

		List<String> aList = Arrays.asList(a.split(""));
		List<String> bList = Arrays.asList(b.split(""));

		Collections.sort(aList);
		Collections.sort(bList);

		int deleteCount = 0;

		for (String ch : aList) {
			aMap.put(ch, aList.lastIndexOf(ch) - aList.indexOf(ch) + 1);
		}

		System.out.println("aMap :- " + aMap);

		for (String ch : bList) {
			bMap.put(ch, bList.lastIndexOf(ch) - bList.indexOf(ch) + 1);
		}

		System.out.println("bMap :- " + bMap);

		int difference = 0;

		Set<String> setOfAllKeysFromBothMaps = new HashSet<>();
		setOfAllKeysFromBothMaps.addAll(aMap.keySet());
		setOfAllKeysFromBothMaps.addAll(bMap.keySet());

		for (String key : setOfAllKeysFromBothMaps) {
			if (aMap.containsKey(key) && bMap.containsKey(key)) {
				difference = difference + Math.abs(aMap.get(key) - bMap.get(key));
			} else if (aMap.containsKey(key)) {
				difference = difference + aMap.get(key);
			} else {
				difference = difference + bMap.get(key);
			}
		}

		System.out.println("Difference :- " + difference);

		return difference;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String a = scanner.nextLine();

		String b = scanner.nextLine();

		int res = makeAnagram(a, b);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}

}