package com.trials.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaDemo_1 {

	public static void main(String[] args) {

		Employee empArr[] = { new Employee("Sachin", 29), new Employee("Abhijeet", 27), new Employee("Shivani", 24),
				new Employee("Priya", 26) };

		List<Employee> employees = Arrays.asList(empArr);

		System.out.println("Employees list as initilized - " + employees);

		Collections.sort(employees, (emp1, emp2) -> {
			return emp1.getName().compareTo(emp2.getName());
		});

		System.out.println("Employees list after sort - " + employees);
	}

}

class Employee {

	private String name;
	private int age;

	public Employee() {

	}

	/**
	 * @param name
	 * @param age
	 */
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}

}
