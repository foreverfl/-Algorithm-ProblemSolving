package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_10872_Factorial {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int result = factorial(num);
		System.out.println(result);
	}

	private static int factorial(int N) {
		if (N <= 1) {
			return 1; // recursion exit
		}
		return N * factorial(N - 1);
	}

}
