package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_05582_CommonPartialString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();

		int max = 0;
		int[][] map = new int[a.length() + 1][b.length() + 1];
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					map[i][j] = map[i - 1][j - 1] + 1;
					max = Math.max(max, map[i][j]);
				}
			}
		}
		System.out.println(max);
	}
}

// reference: https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-5582-%EA%B3%B5%ED%86%B5-%EB%B6%80%EB%B6%84-%EB%AC%B8%EC%9E%90%EC%97%B4-Java