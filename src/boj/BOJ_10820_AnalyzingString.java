package boj;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_10820_AnalyzingString {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int lowercase_cnt = 0;
		int uppercase_cnt = 0;
		int number_cnt = 0;
		int blank_cnt = 0;

		while (sc.hasNext()) {
			lowercase_cnt = 0;
			uppercase_cnt = 0;
			number_cnt = 0;
			blank_cnt = 0;
			String input = sc.nextLine();
			char[] input_arr = input.toCharArray();
			for (int i = 0; i < input_arr.length; i++) {
				if (input_arr[i] >= 'a' && input_arr[i] <= 'z') {
					lowercase_cnt++;
				} else if (input_arr[i] >= 'A' && input_arr[i] <= 'Z') {
					uppercase_cnt++;
				} else if (input_arr[i] >= '0' && input_arr[i] <= '9') {
					number_cnt++;
				} else if (input_arr[i] == ' ') {
					blank_cnt++;
				}
			}
			System.out.println(lowercase_cnt + " " + uppercase_cnt + " " + number_cnt + " " + blank_cnt);
		}
	}

}
