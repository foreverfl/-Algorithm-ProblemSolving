package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02467_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] result = solution(arr);

		System.out.println(result[0] + " " + result[1]);
	}

	private static int[] solution(int[] arr) {
		int[] result = new int[2];
		int left = 0;
		int right = arr.length - 1;
		int sum = 0;
		int min = Integer.MAX_VALUE;

		while (left < right) {
			sum = Math.abs(arr[left] + arr[right]);
			if (sum < min) {
				min = sum;
				result[0] = arr[left];
				result[1] = arr[right];
			}
			if (arr[left] + arr[right] > 0) {
				right--;
			} else if (arr[left] + arr[right] < 0) {
				left++;
			} else {
				result[0] = arr[left];
				result[1] = arr[right];
				break;
			}

		}

		return result;
	}

}
