package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_06162_Superlatives {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(br.readLine());
		for (int i = 1; i <= K; i++) {
			String ans = "";
			st = new StringTokenizer(br.readLine());
			int E = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			if (E <= A) {
				ans = "no drought";
			} else {
				int factor = 0;
				while (E > A) {
					E = E / 5;
					factor++;
				}

				while (factor-- > 1) {
					ans += "mega ";
				}
				ans += "drought";
			}

			sb.append("Data Set " + i + ":").append('\n');
			sb.append(ans).append('\n').append('\n');
		}

		System.out.print(sb.toString());
	}

}
