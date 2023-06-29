package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_09663_NQueen {

	static int[] arr;
	static int N;
	static int count = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		backtracking(0);
		System.out.println(count);

	}

	private static void backtracking(int depth) {
		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i; // depth행, i열
			if (possibility(depth))
				backtracking(depth + 1);
		}

	}

	// 이전의 열에 퀸이 배치되었음을 확인하는 메서드
	private static boolean possibility(int col) {

		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i])
				return false;

			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
				return false;

		}

		return true;
	}

}

// reference: https://st-lab.tistory.com/118
