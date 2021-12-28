package BOJ;

import java.util.Scanner;

public class BOJ_02789_DOM {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char[] input_arr = input.toCharArray();

		String CAMBRIDGE = "CAMBRIDGE";
		char[] CAMBRIDGE_arr = CAMBRIDGE.toCharArray();
		for (int i = 0; i < input_arr.length; i++) {
			for (int j = 0; j < CAMBRIDGE_arr.length; j++) {
				if (input_arr[i] == CAMBRIDGE_arr[j]) {
					input_arr[i] = ' ';
				}
			}
		}

		String result = new String(input_arr);
		result = result.replace(" ", "");
		System.out.println(result);

	}
}
