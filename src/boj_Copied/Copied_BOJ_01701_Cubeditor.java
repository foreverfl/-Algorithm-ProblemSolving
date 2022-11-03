package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_01701_Cubeditor {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int max = 0;
		for (int i = 0; i < str.length(); i++) {
			max = Math.max(max, getMax(str.substring(i, str.length())));
		}
		System.out.println(max);
	}

	private static int getMax(String str) {
		int j = 0, max = 0;
		int pi[] = new int[str.length()];
		for (int i = 1; i < str.length(); i++) {
			while (j > 0 && str.charAt(i) != str.charAt(j))
				j = pi[j - 1];
			
			if (str.charAt(i) == str.charAt(j))
				max = Math.max(max, pi[i] = ++j);
		}
		return max;
	}
}

// reference: https://devowen.com/310