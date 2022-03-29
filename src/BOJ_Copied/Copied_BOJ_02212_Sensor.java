package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Copied_BOJ_02212_Sensor {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		if (K >= N) {
			System.out.println(0);
			return;
		}
		int sum = 0;

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		Integer[] diffArr = new Integer[N - 1];
		for (int i = 0; i < N - 1; i++)
			diffArr[i] = arr[i + 1] - arr[i];

		Arrays.sort(diffArr, Collections.reverseOrder());

		for (int i = K - 1; i < N - 1; i++) {
			sum += diffArr[i];
		}
		System.out.println(sum);
	}
}

// reference: https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-11000-%EA%B0%95%EC%9D%98%EC%8B%A4-%EB%B0%B0%EC%A0%95-Java-wskzqzk6