package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_02747_FibonacciNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int F1 = 0, F2 = 1, F3 = 1;

		for (int i = 2; i <= n; i++) {

			F3 = F1 + F2;

			F1 = F2;

			F2 = F3;

		}

		System.out.println(F3);

	}

}

// reference: https://icandooit.tistory.com/3