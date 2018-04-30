package com.trials.sort;

import java.util.Arrays;

public class Selection_Sort {

	public static void main(String[] args) {

		int arr_1[] = { 0, 5, -6, 4, 3, 1, 10, 7, 15, -2 };

		selection_sort_method(arr_1);
		
		System.out.println("Sorted Array List :- " + Arrays.toString(arr_1));

	}

	public static void selection_sort_method(int arr[]) {

		int index = 0;

		for (int i = 0; i < arr.length - 1; i++) {

			index = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					index = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[index];
			arr[index] = tmp;

		}

	}

}
