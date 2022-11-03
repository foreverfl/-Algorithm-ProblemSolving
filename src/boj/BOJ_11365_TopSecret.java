package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11365_TopSecret {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while (true) {

			input = br.readLine();

			if (input.equals("END")) {
				break;
			}

			StringBuilder sb = new StringBuilder(input);
			input = sb.reverse().toString();
			System.out.println(input);
			sb.setLength(0); // initialization

		}
	}

}
