package com.trials.pattern;

public class Diamond_Pattern {

	public static void main(String[] args) {

		System.out.println("Args : " + args[0]);
		
		draw_diamonds_with_space(Integer.parseInt(args[0]));

		draw_diamonds_without_space(Integer.parseInt(args[0]));
	}

	public static void draw_diamonds_without_space(int max_number) {
		// ascending

		// for loop - number of diamond lines
		for (int i = 1; i <= max_number; i++) {
			// for loop - space characters
			for (int j = 1; j <= (max_number - i); j++) {
				System.out.print(" ");
			}

			// for loop - star character
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("*");
			}

			System.out.println();
		}

		// descending
		// for loop - number of diamond lines
		for (int i = max_number - 1; i >= 1; i--) {
			// for loop - space characters
			for (int j = 1; j <= (max_number - i); j++) {
				System.out.print(" ");
			}

			// for loop - star character
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("*");
			}

			System.out.println();
		}

	}

	public static void draw_diamonds_with_space(int max_number) {

		// ascending

		// for loop - number of diamond lines
		for (int i = 1; i <= max_number; i++) {
			// for loop - space characters
			for (int j = 1; j <= (max_number - i); j++) {
				System.out.print(" ");
			}

			// for loop - star character
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
				System.out.print(" ");
			}

			System.out.println();
		}

		// descending
		// for loop - number of diamond lines
		for (int i = max_number - 1; i >= 1; i--) {
			// for loop - space characters
			for (int j = 1; j <= (max_number - i); j++) {
				System.out.print(" ");
			}

			// for loop - star character
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
				System.out.print(" ");
			}

			System.out.println();
		}

	}

}
