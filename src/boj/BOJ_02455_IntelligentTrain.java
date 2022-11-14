package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02455_IntelligentTrain {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int res = Integer.MIN_VALUE;
		int now = 0;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			now = now - out;
			now = now + in;
			res = Math.max(res, now);
		}

		System.out.println(res);

	}

}
