package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_01969_DNA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] DNA = new String[N];
		for (int i = 0; i < N; i++) {
			DNA[i] = br.readLine();
		}

		Arrays.sort(DNA);

		int[] alphabet = new int[26];

		String ans = "";

		// vertical search
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				alphabet[DNA[j].charAt(i) - 'A']++;
			}

			int max = Integer.MIN_VALUE;
			char most_char = ' ';

			for (int j = 0; j < 26; j++) {
				if (alphabet[j] > max) {
					max = alphabet[j];
					most_char = (char) (j + 'A');
				}
			}
			ans += most_char;

			// initialization
			max = Integer.MIN_VALUE;
			most_char = ' ';
			alphabet = new int[26];

		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (ans.charAt(j) != DNA[i].charAt(j))
					cnt++;
			}
		}

		sb.append(ans).append('\n');
		sb.append(cnt);

		System.out.println(sb.toString());
	}

}
