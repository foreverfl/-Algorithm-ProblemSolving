package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_10798_ReadingVertically {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] arr = new char[5][15];

		for (int i = 0; i < arr.length; i++) { // arr.length == 5
			String input = br.readLine();

			for (int j = 0; j < input.length(); j++) {
				arr[i][j] = input.charAt(j);
			}
		}

		// print
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[j][i] == ' ' || arr[j][i] == '\0') // The '\0' is inserted automatically when a string is over.
					continue;
				System.out.print(arr[j][i]);
			}

		}
	}
}

// reference: https://hith77.tistory.com/126
