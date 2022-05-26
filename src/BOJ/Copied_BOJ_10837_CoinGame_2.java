package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_10837_CoinGame_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());

		while (C-- > 0) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int gap = Math.abs(M - N);
			int remain = K - Math.max(M, N);

			if (M == N) {
				sb.append(1).append('\n');
				
			} else if (M < N) {
				if (gap - remain <= 1) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				
			} else {
				if (gap - remain <= 2) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
			}
		}
		System.out.println(sb.toString());

	}

}

// reference: https://seeminglyjs.tistory.com/139