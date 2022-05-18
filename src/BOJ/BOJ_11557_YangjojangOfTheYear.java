package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11557_YangjojangOfTheYear {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int max = Integer.MIN_VALUE;
		String result = "";

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			while (N-- > 0) {
				st = new StringTokenizer(br.readLine());
				String S = st.nextToken();
				int L = Integer.parseInt(st.nextToken());
				max = Math.max(max, L);

				if (L == max)
					result = S;
			}

			sb.append(result).append('\n');

		}

		System.out.println(sb.toString());
	}

}
