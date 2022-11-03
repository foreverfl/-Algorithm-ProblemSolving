package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_05637_LongestWord {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String answer = "";
		int max = Integer.MIN_VALUE;

		loop: while (true) {
			String[] splited = br.readLine().trim().split(" ");

			for (int i = 0; i < splited.length; i++) {
				splited[i] = splited[i].replaceAll("[^a-zA-Z-]", " ").trim();
				String[] tmp = splited[i].split(" ");

				for (int j = 0; j < tmp.length; j++) {
					if (tmp[j].equals("E-N-D"))
						break loop;

					if (tmp[j].length() > max) {
						max = tmp[j].length();
						answer = tmp[j].toLowerCase();
					}
				}
			}
		}

		System.out.println(answer);

	}

}

// reference: https://ddb8036631.github.io/boj/5637_%EA%B0%80%EC%9E%A5-%EA%B8%B4-%EB%8B%A8%EC%96%B4/
