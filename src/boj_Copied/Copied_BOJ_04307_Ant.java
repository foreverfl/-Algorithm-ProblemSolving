package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_04307_Ant {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int pole = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			int min = Integer.MIN_VALUE;
			int max = Integer.MIN_VALUE;

			for (int i = 0; i < n; i++) {
				int ant = Integer.parseInt(br.readLine());

				int antMin = Math.min(ant, pole - ant);
				int antMax = Math.max(ant, pole - ant);

				min = Math.max(min, antMin);
				max = Math.max(max, antMax);
			}

			sb.append(min + " " + max).append('\n');

		}

		System.out.println(sb.toString());
	}

}

// reference: https://pangsblog.tistory.com/22