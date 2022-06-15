package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10252_GridGraphs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			sb.append("1").append('\n');

			boolean flag = true;
			for (int i = 0; i < m; i++) {

				if (flag) {
					for (int j = 1; j < n; j++) {
						sb.append("(" + i + "," + j + ")").append('\n');
					}
					flag = !flag;
				} else {
					for (int j = n - 1; j >= 1; j--) {
						sb.append("(" + i + "," + j + ")").append('\n');
					}
					flag = !flag;
				}

			}

			for (int i = m - 1; i >= 0; i--) {
				sb.append("(" + i + "," + 0 + ")").append('\n');
			}

		}

		System.out.print(sb.toString().trim());
	}

}
