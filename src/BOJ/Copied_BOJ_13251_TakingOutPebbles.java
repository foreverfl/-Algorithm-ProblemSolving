package BOJ;

import java.io.*;
import java.util.*;

public class Copied_BOJ_13251_TakingOutPebbles {
	static int n, m, k;
	static double answer;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(br.readLine());
		arr = new int[m];
		n = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			n += arr[i];
		}

		k = Integer.parseInt(br.readLine());
		answer = 0;
		for (int i = 0; i < m; i++) {
			Combination(i);
		}
		System.out.println(answer >= 1 ? 1 : answer); // important
	}

	static void Combination(int pick) {
		if (arr[pick] >= k) {
			int tmp1 = n;
			int tmp2 = k;
			double tmpAnswer = 1;
			while (tmp2-- > 0) {
				tmpAnswer *= (arr[pick]-- / (double) tmp1--);
			}
			answer += tmpAnswer;
		}
		return;
	}
}