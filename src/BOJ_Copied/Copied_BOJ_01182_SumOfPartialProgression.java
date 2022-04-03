package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01182_SumOfPartialProgression {

	static int[] arr;
	static int N, S;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		backtracking(0, 0);

		if (S == 0)
			System.out.println(cnt - 1);
		else
			System.out.println(cnt);
	}

	private static void backtracking(int depth, int sum) {
		if (depth == N) {
			if (sum == S)
				cnt++;
			return;
		}

		backtracking(depth + 1, sum + arr[depth]);
		backtracking(depth + 1, sum);
	}

}

// reference: https://youngest-programming.tistory.com/515
