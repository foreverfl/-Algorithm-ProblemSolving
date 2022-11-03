package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_05598_CaesarPassword {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(toCaesar(input));
	}

	private static String toCaesar(String input) {
		String result = "";

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= 'D') {
				result += (char) (input.charAt(i) - 3);
			} else {
				result += (char) (input.charAt(i) + 23);
			}
		}

		return result;
	}

}
