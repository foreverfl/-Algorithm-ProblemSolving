package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10258_SwitchArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {

			String str = br.readLine();

			int ans = 0;
			boolean flag = true;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '1') {
					if (flag) {
						ans += (Math.pow(2, str.length() - i) - 1);
					} else {
						ans -= (Math.pow(2, str.length() - i) - 1);
					}
					flag = !flag;
				}
			}

			sb.append(ans).append('\n');
		}

		System.out.println(sb.toString());
	}

}

// reference: https://katfun.tistory.com/entry/%EB%B0%B1%EC%A4%80-10258%EB%B2%88-%EC%8A%A4%EC%9C%84%EC%B9%98-%EB%B0%B0%EC%97%B4