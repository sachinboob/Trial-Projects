package com.trials.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Lambda_Function {

	public static void main(String[] args) {

		List<Student> studentsList = new ArrayList<>();

		// Populate students list
		studentsList.add(new Student(0, "Sachin Boob"));
		studentsList.add(new Student(1, "Abhijeet Kulkarni"));
		studentsList.add(new Student(3, "Vaijayanti Keni"));
		studentsList.add(new Student(2, "Shivani Rane"));
		studentsList.add(new Student(4, "Divya Bajaj"));

		// Return student first name
		Function<Student, String> getStudentFirstName = (Student student) -> {
			return student.name.split(" ")[0];
		};

		// Return student last name
		Function<Student, String> getStudentLastName = (Student student) -> {
			return student.name.split(" ")[1];
		};

		// Make first name uppercase
		Function<String, String> upperCase = (String name) -> {
			return name.toUpperCase();
		};

		// Chained function
		Function<Student, String> chainedFunction = getStudentFirstName.andThen(upperCase);

		System.out.println("Student name in uppercase - " + chainedFunction.apply(studentsList.get(3)));

		Random random = new Random();

		// Loop to print name
		studentsList.forEach((Student student) -> {

			if (random.nextBoolean()) {
				System.out.println("Printing student's first name - " + getName(getStudentFirstName, student));
			} else {
				System.out.println("Printing student's last name - " + getName(getStudentLastName, student));
			}
		});
	}

	private static String getName(Function<Student, String> functionForStudent, Student student) {
		return functionForStudent.apply(student);
	}
}