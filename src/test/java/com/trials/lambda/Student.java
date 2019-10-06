package com.trials.lambda;

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