package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_02231_DigitGenerator {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int result = 0;

		for (int i = 0; i < N; i++) {
			int number = i;
			int sum = 0;

			// adding all numbers
			while (number != 0) {
				sum += number % 10;
				number /= 10;
			}

			if (sum + i == N) {
				result = i;
				break;
			}

		}

		System.out.println(result);
	}
}

// reference: https://st-lab.tistory.com/98