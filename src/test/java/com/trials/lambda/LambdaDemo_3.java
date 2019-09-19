package com.trials.lambda;

public class LambdaDemo_3 {

	public static void main(String[] args) {

		String str1 = "abc", str2 = "def";
		UpperConcat uc = (s1, s2) -> {
			String result = s1.toUpperCase() + s2.toUpperCase();
			return result;
		};

		System.out.println("Doing silly stuff with Strings - " + str1 + " , " + str2);
		System.out.println(doSillyStuffWithString(uc, str1, str2));
	}

	public static final String doSillyStuffWithString(UpperConcat uc, String s1, String s2) {
		return uc.upperAndConcat(s1, s2);
	}
}

@FunctionalInterface
interface UpperConcat {
	public abstract String upperAndConcat(String s1, String s2);
}
