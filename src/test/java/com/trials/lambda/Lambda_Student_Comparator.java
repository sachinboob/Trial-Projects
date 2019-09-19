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

class Student implements Comparable<Student> {

	int rollNumber;
	String name;

	/**
	 * @param rollNumber
	 * @param name
	 */
	public Student(int rollNumber, String name) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Student student) {
		return new Integer(rollNumber).compareTo(((Student) student).rollNumber);
	}

}
