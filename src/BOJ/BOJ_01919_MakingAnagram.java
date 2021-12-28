package BOJ;

import java.util.Scanner;

public class BOJ_01919_MakingAnagram {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 1. excluding what is same 2. counting length of strings

		Scanner sc = new Scanner(System.in);
		String input1 = sc.next();
		String input2 = sc.next();

		char[] input1_arr = input1.toCharArray();
		char[] input2_arr = input2.toCharArray();

		for (int i = 0; i < input1_arr.length; i++) {
			for (int j = 0; j < input2_arr.length; j++) {
				if (input1_arr[i] == input2_arr[j]) {
					input1_arr[i] = ' ';
					input2_arr[j] = ' ';
				}
			}
		}
		input1 = new String(input1_arr);
		input2 = new String(input2_arr);

		input1 = input1.replace(" ", "");
		input2 = input2.replace(" ", "");

		System.out.println(input1.length() + input2.length());

	}

}
