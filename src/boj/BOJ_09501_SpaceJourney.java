package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_09501_SpaceJourney {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int ans = 0;
			while (N-- > 0) {
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int f = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				double possibleDist = v * (double) f / c;

				if (possibleDist >= (double) D)
					ans++;
			}
			sb.append(ans).append('\n');
		}

		System.out.print(sb.toString());
	}

}
