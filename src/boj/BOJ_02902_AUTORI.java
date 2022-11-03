package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02902_AUTORI {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] input_arr = input.split("");

		StringBuilder sb = new StringBuilder();

		sb.append(input_arr[0]); // first character

		for (int i = 1; i < input_arr.length - 1; i++) {
			if (input_arr[i].equals("-")) {
				sb.append(input_arr[i + 1]);
			}
		}
		System.out.println(sb.toString());
	}

}
