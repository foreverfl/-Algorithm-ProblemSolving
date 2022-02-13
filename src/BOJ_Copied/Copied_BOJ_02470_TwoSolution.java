package BOJ_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_02470_TwoSolution {


	static int pick1 = -1;
	static int pick2 = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		solution(N, arr);

		System.out.println(pick1 + " " + pick2);
	}

	static void solution(int n, int[] arr) {
		int left = 0;
		int right = n - 1;
		int max = Integer.MAX_VALUE;

		while (left < right) {
			int sum = arr[left] + arr[right];

			if (Math.abs(sum) < max) {
				pick1 = arr[left];
				pick2 = arr[right];
				max = Math.abs(sum);
			}

			if (sum > 0)
				right--;
			else
				left++;
		}
	}
}

// reference: https://bcp0109.tistory.com/55