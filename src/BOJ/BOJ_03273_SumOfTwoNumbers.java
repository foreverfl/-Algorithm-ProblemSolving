package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_03273_SumOfTwoNumbers {
	static int n, x;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		x = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		System.out.println(findSum(arr));
	}

	private static int findSum(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int cnt = 0;
		int sum = 0;
		while (left < right) {
			sum = 0;
			sum = arr[left] + arr[right];
			if (sum >= x) {
				right--;
				if (sum == x) {
					cnt++;
				}
			} else {
				left++;
			}
		}

		return cnt;
	}
}
