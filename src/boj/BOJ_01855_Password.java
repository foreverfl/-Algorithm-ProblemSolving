package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01855_Password {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		String coded = br.readLine();

		StringBuilder sb = new StringBuilder();
		String[] tmp = new String[K];
		for (int i = 0; i < K; i++) {
			tmp[i] = "";
		}

		int idx_coded = 0;
		boolean flag = true;
		while (true) {
			if (flag) {
				for (int i = 0; i < K; i++) {
					tmp[i] += coded.charAt(idx_coded++);
				}
				flag = false;
			} else {
				for (int i = K - 1; i >= 0; i--) {
					tmp[i] += coded.charAt(idx_coded++);
				}
				flag = true;
			}

			if (idx_coded == coded.length())
				break;

		}

		for (int i = 0; i < K; i++) {
			sb.append(tmp[i].toString());
		}

		System.out.println(sb.toString());

	}

}
