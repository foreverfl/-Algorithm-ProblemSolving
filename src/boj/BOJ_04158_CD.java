package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_04158_CD {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String str = br.readLine();
		while (!str.equals("0 0")) {
			st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			Set<Integer> set = new HashSet<>();

			while (N-- > 0) {
				int input = Integer.parseInt(br.readLine());
				set.add(input);
			}

			int cnt = 0;
			while (M-- > 0) {
				int input = Integer.parseInt(br.readLine());
				if (set.contains(input))
					cnt++;
			}

			sb.append(cnt).append('\n');
			str = br.readLine();
		}

		System.out.println(sb.toString());
	}

}
