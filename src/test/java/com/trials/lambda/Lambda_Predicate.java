package com.trials.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lambda_Predicate {

	public static void main(String[] args) {

		List<Student> studentsList = new ArrayList<>();

		studentsList.add(new Student(0, "Sachin"));
		studentsList.add(new Student(1, "Abhijeet"));
		studentsList.add(new Student(3, "Vaijayanti"));
		studentsList.add(new Student(2, "Shivani"));
		studentsList.add(new Student(4, "Divya"));

		Predicate<Student> studentsWithRollNumberLessThan3 = student -> student.rollNumber < 3;
		Predicate<Student> studentsWithNameStartsWithS = student -> student.name.startsWith("S");
		Predicate<Student> alwaysTrue = (student) -> {
			return true;
		};

		printStudentByCondition(studentsList, "Students with Roll Number less than 3 - ",
				studentsWithRollNumberLessThan3);

		printStudentByCondition(studentsList, "Students with Name starting with 'S' - ", studentsWithNameStartsWithS);

		printStudentByCondition(studentsList, "Students with Name starting with 'S' - ",
				student -> student.rollNumber == 0);

		printStudentByCondition(studentsList, "Print all students - ", alwaysTrue);
	}

	private static void printStudentByCondition(List<Student> studentsList, String conditionDescription,
			Predicate<Student> condition) {
		System.out.println();
		System.out.println("******" + conditionDescription + "******");
		for (Student student : studentsList) {
			if (condition.test(student)) {
				System.out.println(student);
			}
		}
	}
}