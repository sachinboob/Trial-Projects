package com.trials.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {

		List<String> myList = new ArrayList<>();
		String[] arrArr = { "abc", "def", "ghi", "jkl" };

		myList.addAll(Arrays.asList(arrArr));
		
	}

}
