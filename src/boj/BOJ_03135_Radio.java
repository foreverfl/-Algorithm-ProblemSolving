package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_03135_Radio {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];

		int tmp = Integer.MAX_VALUE;
		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (Math.abs(to - arr[i]) < Math.abs(to - tmp)) {
				tmp = arr[i];
			}
		}

		int result_1 = Math.abs(from - to);
		int result_2 = Math.abs(tmp - to) + 1;
		int result_final = Math.min(result_1, result_2);

		System.out.println(result_final);

	}

}
