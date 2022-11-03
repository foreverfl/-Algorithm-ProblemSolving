package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_18406_LuckyStraight {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int left = 0;
		for (int i = 0; i < input.length() / 2; i++) {
			left += input.charAt(i) - '0';
		}

		int right = 0;
		for (int i = input.length() / 2; i < input.length(); i++) {
			right += input.charAt(i) - '0';
		}

		if (left == right)
			System.out.println("LUCKY");
		else
			System.out.println("READY");
	}

}
