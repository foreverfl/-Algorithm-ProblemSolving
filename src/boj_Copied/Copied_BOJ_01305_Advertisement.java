package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_01305_Advertisement {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		String str = br.readLine();

		int lastPi = getLastPi(str);
		System.out.println(n - lastPi);
	}

	static int getLastPi(String str) {
		int len = str.length();
		int j = 0;
		int[] pi = new int[len];

		for (int i = 1; i < len; i++) {
			while (j > 0 && str.charAt(j) != str.charAt(i)) {
				j = pi[j - 1];
			}

			if (str.charAt(j) == str.charAt(i)) {
				pi[i] = ++j;
			}
		}

		return pi[len - 1];
	}

}

// reference: https://maivve.tistory.com/205