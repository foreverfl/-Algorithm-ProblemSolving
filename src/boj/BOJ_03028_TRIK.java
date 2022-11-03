package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_03028_TRIK {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(mix(str));
	}

	private static int mix(String str) {
		int[] cup = new int[3];
		cup[0] = 1;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'A') {

				if (cup[0] == 1) {
					cup[0] = 0;
					cup[1] = 1;
				} else if (cup[1] == 1) {
					cup[0] = 1;
					cup[1] = 0;
				} else {
					continue;
				}

			} else if (str.charAt(i) == 'B') {

				if (cup[1] == 1) {
					cup[1] = 0;
					cup[2] = 1;
				} else if (cup[2] == 1) {
					cup[1] = 1;
					cup[2] = 0;
				} else {
					continue;
				}

			} else {

				if (cup[0] == 1) {
					cup[0] = 0;
					cup[2] = 1;
				} else if (cup[2] == 1) {
					cup[0] = 1;
					cup[2] = 0;
				} else {
					continue;
				}

			}
		}

		if (cup[0] == 1)
			return 1;
		else if (cup[1] == 1)
			return 2;
		else
			return 3;
	}

}
