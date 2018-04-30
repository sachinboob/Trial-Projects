package com.trials.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bubble_Sort {

	public static void main(String[] args) {

		int arr_1[] = { 0, 5, -6, 4, 3, 1, 10, 7, 15, -2 };
		bubble_sort_method(arr_1);
		System.out.println("Sorted array arr_1 - " + Arrays.toString(arr_1));

		int arr_2[] = { 0, 5, -6, 4, 3, 1, 10, 7, 15, -2 };
		Arrays.sort(arr_2);
		System.out.println("Sorted array arr_2 - " + Arrays.toString(arr_2));

		Integer arr_3[] = { 0, 5, -6, 4, 3, 1, 10, 7, 15, -2 };
		List<Integer> arr_3_list = Arrays.asList(arr_3);
		Collections.sort(arr_3_list);
		System.out.println("Sorted array arr_3 - " + arr_3_list);
	}

	public static void bubble_sort_method(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}

}
