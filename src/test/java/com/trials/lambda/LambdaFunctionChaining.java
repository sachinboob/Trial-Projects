package com.trials.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaFunctionChaining {

	public static void main(String[] args) {

		// Lambda 1
		Function<Student, String> getFirstName = student -> student.name.split(" ")[0];

		// Lambda 2
		Function<String, String> doUpperCase = str -> str.toUpperCase();

		// Lambda 3
		Function<String, String> splitEachCharacterWithComma = str -> String.join(",", str.split(""));

		// Chained lambda
		Function<Student, String> chainedFunction = getFirstName.andThen(doUpperCase)
				.andThen(splitEachCharacterWithComma);

		// Print
		System.out.println(chainedFunction.apply(new Student(99, "Sachin Boob")));

		// BiFunction
		BiFunction<String, Student, String> nameAndRollNo = (String name, Student student) -> {
			return name.concat(" ").concat(String.valueOf(student.rollNumber));
		};

		// Print
		System.out.println("Student's name and roll number are :- "
				+ nameAndRollNo.apply(new Student(99, "Sachin Boob").name, new Student(99, "Sachin Boob")));

	}

}
