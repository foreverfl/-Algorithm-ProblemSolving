package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_25205_FunkOfSeniorCitizensCenter {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();

		char[] consonants = new char[] { 'q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v' };

		for (int i = 0; i < consonants.length; i++) {
			if (s.charAt(s.length() - 1) == consonants[i]) {
				System.out.println(1);
				return;
			}
		}

		System.out.println(0);

	}

}
