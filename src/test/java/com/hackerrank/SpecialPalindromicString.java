package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SpecialPalindromicString {

	// Complete the substrCount function below.
	static long substrCount(int n, String s) {
		long countOfSpecialStrings = 0;

		if (n == 0) {
			return countOfSpecialStrings;
		}

		countOfSpecialStrings = s.length();

		if (countOfSpecialStrings <= 2) {
			return countOfSpecialStrings;
		}

		List<String> subStrings = new ArrayList<>();

		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				subStrings.add(s.substring(i, j + 1));
			}
		}

//		System.out.println(subStrings.toString());

		boolean flag = true;
		for (String str : subStrings) {

			if ((str.length() % 2) == 0) {
				flag = isFitForSpecialString(str);
			} else {
				flag = isFitForSpecialString(str.substring(0, str.length() / 2) + str.substring(str.length() / 2 + 1));
			}

			if (flag) {
//				System.out.println(str + " is special string");
				countOfSpecialStrings++;
			}
		}

		System.out.println("Total numnber of special strings :- " + countOfSpecialStrings);

		return countOfSpecialStrings;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		long result = substrCount(n, s);

//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();

//		bufferedWriter.close();

		scanner.close();
	}

	public static boolean isFitForSpecialString(final String str) {
		boolean flag = true;

		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i; j < str.length(); j++)
				if (str.charAt(i) != str.charAt(j)) {
					flag = false;
				}
		}

		return flag;
	}
}
