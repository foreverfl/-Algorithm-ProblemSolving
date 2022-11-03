package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01062_Lesson {

	static int N, K;
	static int max = Integer.MIN_VALUE;
	static boolean[] visited;
	static String[] word;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		word = new String[N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			str = str.replace("anta", "");
			str = str.replace("tica", "");
			word[i] = str;
		}

		if (K < 5) {
			System.out.println("0");
			return;
		} else if (K == 26) {
			System.out.println(N);
			return;
		}

		visited = new boolean[26];
		visited['a' - 'a'] = true;
		visited['c' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;

		backtracking(0, 0);
		
		System.out.println(max);
	}

	private static void backtracking(int alpha, int len) {
		if (len == K - 5) {
			int cnt = 0;
			for (int i = 0; i < N; i++) { 
				boolean read = true;
				for (int j = 0; j < word[i].length(); j++) {
					if (!visited[word[i].charAt(j) - 'a']) {
						read = false;
						break;
					}
				}
				if (read)
					cnt++;
			}
			max = Math.max(max, cnt);
			return;
		}

		for (int i = alpha; i < 26; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				backtracking(i, len + 1);
				visited[i] = false;
			}
		}
	}
}

// reference: https://moonsbeen.tistory.com/188
