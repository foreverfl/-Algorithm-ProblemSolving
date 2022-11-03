package boj;

import java.util.Scanner;

public class BOJ_02864_ZBROJ {

	public static int convert_to_max(String input) {
		String arr[] = input.split("");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("5")) {
				arr[i] = "6";
			}

		}

		int result = Integer.parseInt(String.join("", arr));
		return result;
	}

	public static int convert_to_min(String input) {
		String arr[] = input.split("");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("6")) {
				arr[i] = "5";
			}

		}
		int result = Integer.parseInt(String.join("", arr));
		return result;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		
		int max = convert_to_max(A) + convert_to_max(B);
		int min = convert_to_min(A) + convert_to_min(B);
		
		System.out.println(min + " " + max);

	}

}
