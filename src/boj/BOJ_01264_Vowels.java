package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01264_Vowels {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		while (!str.equals("#")) {

			int cnt = 0;
			char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
			for (int i = 0; i < str.length(); i++) {
				for (int j = 0; j < vowels.length; j++) {
					if (str.charAt(i) == vowels[j])
						cnt++;
				}
			}
			sb.append(cnt).append('\n');

			str = br.readLine();
		}

		System.out.println(sb.toString());
	}

}
