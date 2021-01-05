package com.trials.streams;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

public class StreamsDemo {

	public static void main(String[] args) throws Exception {

		String[] stringArray = { "N40", "N36", "B12", "B6", "G59", "G53", "G53", "G50", "I17", "I29", "O71" };
		List<String> someBingoNumbers = Arrays.asList(stringArray);

		someBingoNumbers.stream()
				.map(String::toUpperCase)
				.filter((String str) -> str.startsWith("G"))
				.sorted()
				.forEach(System.out::println);

		System.out.println("-------------------------------------------------------");

		someBingoNumbers.stream()
				.map((String str) -> str.concat("X"))
				.filter((String str) -> !str.contains("6"))
				.sorted((String str1, String str2) -> str2.compareTo(str1))
				.min((String str1, String str2) -> str1.compareTo(str2));

		File allRecords = new File("C:\\Users\\sachin.boob\\Desktop\\All-Records.txt");

		File failedRecords = new File(
				"C:\\Users\\sachin.boob\\OneDrive - Jade Global Software Pvt Ltd\\RSC\\QAT Migration Execution\\VM Logs\\Role update\\Failure_Role_Consolidated.txt");

		File successRecords = new File(
				"C:\\Users\\sachin.boob\\OneDrive - Jade Global Software Pvt Ltd\\RSC\\QAT Migration Execution\\VM Logs\\Role update\\Success_Role_Consolidated.txt");

		List<String> allRecordLines = FileUtils.readLines(allRecords);

		List<String> successRecordLines = FileUtils.readLines(successRecords);

		List<String> failedRecordLines = FileUtils.readLines(failedRecords, "UTF-8");

		successRecordLines.addAll(failedRecordLines);
		System.out.println("Merge count :- " + successRecordLines.size());
		System.out.println("Merge count :- " + successRecordLines.stream()
				.distinct()
				.collect(Collectors.toList())
				.size());

		System.out.println(successRecordLines.stream()
				.filter(s -> successRecordLines.lastIndexOf(s) - successRecordLines.indexOf(s) > 0)
				.collect(Collectors.toList()));

		List<String> missingUsers = allRecordLines.stream()
				.filter(str -> !successRecordLines.contains(str))
				.collect(Collectors.toList());

		System.out.println("Missing Users :- " + missingUsers.size());
		System.out.println(missingUsers);

		File failedRegistrations = new File(
				"C:\\Users\\sachin.boob\\OneDrive - Jade Global Software Pvt Ltd\\RSC\\QAT Migration Execution\\Registration-Failures-Consolidated.txt");

		List<String> failedRegistrationLines = FileUtils.readLines(failedRegistrations);

		List<String> failedUpdateNotInFailedRegistrations = failedRecordLines.stream()
				.filter(str -> !failedRegistrationLines.contains(str))
				.collect(Collectors.toList());

		System.out.println("Records - " + failedUpdateNotInFailedRegistrations.size());
		System.out.println(failedUpdateNotInFailedRegistrations);

//		System.out.println("List size " + failedRecordLines.size());
//
//		System.out.println("Distinct list siz " + failedRecordLines.stream()
//				.distinct()
//				.collect(Collectors.toList())
//				.size());

	}
}