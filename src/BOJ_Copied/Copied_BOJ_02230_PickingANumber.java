package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_02230_PickingANumber {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int firstPointer = 0;
		int secondPointer = 0;
		int min = Integer.MAX_VALUE;

		while (firstPointer < N) {
			if (arr[firstPointer] - arr[secondPointer] < M) {
				firstPointer++;
				continue;
			}

			if (arr[firstPointer] - arr[secondPointer] == M) {
				min = M;
				break;
			}

			min = Math.min(min, arr[firstPointer] - arr[secondPointer]);
			secondPointer++;
		}

		sb.append(min + "\n");
		System.out.println(sb);
	}

}

// reference: https://steady-coding.tistory.com/60
