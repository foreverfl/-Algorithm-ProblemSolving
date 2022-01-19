package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_02003_SumOfTheNumbers_2 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}

		System.out.println(twoPointer(arr, M));
	}

	static int twoPointer(int[] arr, int m) {
		int count = 0;
		int startPoint = 0, endPoint = 0;
		int length = arr.length;
		int sum = 0;

		while (true) {
			if (sum >= m) {
				sum -= arr[startPoint++];
			} else if (endPoint >= length) {
				break;
			} else { // M < sum
				sum += arr[endPoint++];
			}

			if (sum == m) {
				count++;
			}
		}

		return count;
	}
}

// reference: https://maivve.tistory.com/223
