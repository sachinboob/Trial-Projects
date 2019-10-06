package com.trials.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lambda_Student_Comparator {

	public static void main(String[] args) throws Exception {

		List<Student> studentsList = new ArrayList<>();

		studentsList.add(new Student(0, "Sachin"));
		studentsList.add(new Student(1, "Abhijeet"));
		studentsList.add(new Student(3, "Vaijayanti"));
		studentsList.add(new Student(2, "Shivani"));
		studentsList.add(new Student(4, "Divya"));

		// Print un sorted list
		System.out.println("Students list not sorted:- " + studentsList);

		// Sort with Comparable
		Collections.sort(studentsList);

		// Print sorted list
		System.out.println("Students list     sorted:- " + studentsList);

		// Reverse the list and print
		Collections.reverse(studentsList);
		System.out.println("Students list   reversed:- " + studentsList);

		// Sort again with Comparator (by roll number) lambda and print
		Collections.sort(studentsList, (Student student1, Student student2) -> {
			return new Integer(student1.rollNumber).compareTo(student2.rollNumber);
		});
		System.out.println("Students list     sorted by roll number:- " + studentsList);

		// Sort by name and print
		Collections.sort(studentsList, (s1, s2) -> {
			return s1.name.compareTo(s2.name);
		});
		System.out.println("Students list     sorted by name:- " + studentsList);

		// Print all items using lambda expression
		System.out.println("Print Students list using lambda expression:- ");
		studentsList.forEach(s -> System.out.println(s.toString()));
	}
}