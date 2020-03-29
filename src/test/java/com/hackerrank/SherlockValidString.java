package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockValidString {

	// Complete the isValid function below.
	static String isValid(String s) {

		String isStringValid = "YES";

		List<String> sList = Arrays.asList(s.split(""));
		Collections.sort(sList);
		Map<String, Integer> sMap = new HashMap<>();

		sList.forEach((String str) -> {
			sMap.put(str, sList.lastIndexOf(str) - sList.indexOf(str) + 1);
		});

//		for (String str : sList) {
//			);
//		}

		System.out.println("Character counts map :- " + sMap.toString());

		List<Integer> characterCountList = new ArrayList<>();

		for (String str : sMap.keySet()) {
			characterCountList.add(sMap.get(str));
		}

		Collections.sort(characterCountList);
		Collections.reverse(characterCountList);

		System.out.println("Character Count List :- " + characterCountList.toString());

		// Compare first and last - if equal then YES
		if (characterCountList.get(0) == characterCountList.get(characterCountList.size() - 1)) {
			isStringValid = "YES";
			return isStringValid;
		}

		boolean isSameForward = true;

		characterCountList.set(0, characterCountList.get(0) - 1);
		if (characterCountList.get(0) == 0) {
			characterCountList.remove(0);
		}

		isSameForward = true;
		for (Integer c : characterCountList) {
			if (characterCountList.get(0) != c) {
				isSameForward = false;
				break;
			}
		}

		System.out.println("Charactercount list :- " + characterCountList.toString());

		characterCountList.set(0, characterCountList.get(0) + 1);
		Collections.reverse(characterCountList);
		characterCountList.set(0, characterCountList.get(0) - 1);
		if (characterCountList.get(0) == 0) {
			characterCountList.remove(0);
		}

		boolean isSameBackward = true;

		for (Integer c : characterCountList) {
			if (characterCountList.get(0) != c) {
				isSameBackward = false;
				break;
			}
		}

		System.out.println("Charactercount list :- " + characterCountList.toString());

		if (isSameForward || isSameBackward) {
			isStringValid = "YES";
		} else {
			isStringValid = "NO";
		}

		System.out.println(isStringValid);

		return isStringValid;
	}

//	private static final 

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//		Scanner scanner = new Scanner(new FileInputStream("input.txt"));

//		String s = scanner.nextLine();

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

		StringBuffer s = new StringBuffer(br.readLine());

		System.out.println("String length = " + s.length());

		System.out.println("Scanned string :- " + s);

//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
//
//		bufferedWriter.write(br.readLine());
		br.close();
//		bufferedWriter.close();

		String result = isValid(s.toString());

//		bufferedWriter.write(result);
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();

//		scanner.close();
	}
}
