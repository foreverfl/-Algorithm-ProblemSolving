package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_15658_InsertingOperator_2 {

	static int[] num;
	static int[] op;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		op = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		backTracking(1, num[0]);

		sb.append(max).append('\n');
		sb.append(min).append('\n');

		System.out.println(sb.toString());
	}

	private static void backTracking(int depth, int sum) {
		if (depth == N) {
			min = Math.min(sum, min);
			max = Math.max(sum, max);
			return;
		}

		int start = num[depth];

		for (int i = 0; i < 4; i++) {
			if (op[i] <= 0)
				continue;

			int temp_sum = sum;

			if (i == 0)
				temp_sum += start;
			else if (i == 1)
				temp_sum -= start;
			else if (i == 2)
				temp_sum *= start;
			else
				temp_sum /= start;

			op[i]--;
			backTracking(depth + 1, temp_sum);
			op[i]++;

		}

		return;
	}

}

// reference: https://kwoncorin.tistory.com/35
