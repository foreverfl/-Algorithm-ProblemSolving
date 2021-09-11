package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _1157_StudyingWords {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[26];
		String input = br.readLine();

		for (int i = 0; i < input.length(); i++) {
			if ('a' <= input.charAt(i) && input.charAt(i) <= 'z') {
				arr[input.charAt(i) - 97]++;
			} else {
				arr[input.charAt(i) - 65]++;
			}
		}
		
		int max = -1;
		char ch = '?';
		for (int i = 0; i < 26; i++) {

			if (arr[i] > max) {
				max = arr[i];
				ch = (char) (i + 65);
			} else if (arr[i] == max) {
				ch = '?';
			}
		}
		System.out.print(ch);
	}

}
