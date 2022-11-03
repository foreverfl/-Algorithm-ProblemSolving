package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_01920_FindingNumbers {

	public static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // the first input line
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // the second input line
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr); // Arrays must be arranged.

		int M = Integer.parseInt(br.readLine()); // the third input line

		st = new StringTokenizer(br.readLine(), " "); // the fourth input line

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {

			// If there is a value to find, it returns 1. Otherwise, it does 0.
			if (binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}

	public static int binarySearch(int key) {

		int low = 0;
		int high = arr.length - 1;

		// It repeats until the 'low' becomes the 'high.'
		while (low <= high) {

			int mid = (low + high) / 2; 

			// a value of key is smaller than the 'mid.'
			if (key < arr[mid]) {
				high = mid - 1;
			}
			// a value of key is lager than the 'mid.'
			else if (key > arr[mid]) {
				low = mid + 1;
			}
			// two values are same.
			else {
				return mid;
			}
		}

		// There is not a value.
		return -1;

	}
}