package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solving_BOJ_26031_HighestHill {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		long arr[] = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		long ans = Long.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, findHighestHill(arr, i));
		}

		bw.write(ans + " ");
		bw.flush();
		bw.close();

	}

	private static long findHighestHill(long[] arr, int now_idx) {

		long ans = Long.MIN_VALUE;
		int left_idx = now_idx;
		int right_idx = now_idx;
		while (true) {
			left_idx--;
			right_idx++;

			if (left_idx < 0 || right_idx > arr.length - 1)
				break;

			if (arr[now_idx] < arr[left_idx] || arr[now_idx] < arr[right_idx])
				break;

			long left = arr[now_idx] - arr[left_idx];
			long right = arr[now_idx] - arr[right_idx];
			long tmp = Math.min(left, right);
			ans = Math.max(ans, tmp);

		}
		return ans;
	}

}
