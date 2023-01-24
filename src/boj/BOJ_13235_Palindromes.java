package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13235_Palindromes {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());

		if (sb.toString().equals(sb.reverse().toString())) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

}
