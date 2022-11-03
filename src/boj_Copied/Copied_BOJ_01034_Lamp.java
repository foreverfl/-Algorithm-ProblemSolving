package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01034_Lamp {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			str[i] = st.nextToken();
		}

		st = new StringTokenizer(in.readLine());
		int K = Integer.parseInt(st.nextToken());
		int oddEven = K % 2;
		if (K > 50) { // The number of maximum pushing count is 50.
			K = 50;
		}

		int max = 0;
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			int zeroNum = 0;
			String tmp = str[i];
			// counting 0
			for (int j = 0; j < M; j++) {
				if (tmp.charAt(j) == '0')
					zeroNum++;
			}

			// checking whether they are same in odd and even or not
			if (zeroNum % 2 != oddEven) {
				continue;
			}

			int patern = 1;
			// counting same pattern
			for (int j = 0; j < N; j++) {
				if (j != i && tmp.equals(str[j])) {
					patern++;
				}
			}
			// The number of 0 can't be more than K.
			if (zeroNum <= K && patern > max) {
				max = patern;
				flag = true;
			}
		}
		if (flag) {
			System.out.println(max);
		} else {
			System.out.println(0);
		}
	}

}

// reference: https://moons-memo.tistory.com/93
