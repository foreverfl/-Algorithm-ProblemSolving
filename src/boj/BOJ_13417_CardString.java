package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13417_CardString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			String tmp = "";
			while (N-- > 0) {
				char cha = st.nextToken().charAt(0);

				if (tmp.equals("")) {
					tmp += cha;
				} else {
					if (cha > tmp.charAt(0)) {
						tmp += cha;
					} else if (cha <= tmp.charAt(0)) {
						tmp = cha + tmp;
					}
				}

			}
			sb.append(tmp).append('\n');
		}

		System.out.println(sb.toString());
	}

}
