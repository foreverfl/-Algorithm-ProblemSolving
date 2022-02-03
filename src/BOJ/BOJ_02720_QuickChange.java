package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02720_QuickChange {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int C = Integer.parseInt(br.readLine());

			// 25cent
			int Q = C / 25;
			int Q_change = C % 25;

			// 10cent
			int D = Q_change / 10;
			int D_change = Q_change % 10;

			// 5cent
			int N = (D_change % 10) / 5;
			int N_change = D_change % 10;

			// 1cent
			int P = (N_change % 5);

			// result
			sb.append(Q + " " + D + " " + N + " " + P).append("\n");
		}

		System.out.println(sb);

	}

}
