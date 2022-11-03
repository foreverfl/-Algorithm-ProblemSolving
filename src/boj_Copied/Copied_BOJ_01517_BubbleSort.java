package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01517_BubbleSort {

	static long ans;
	static long[] elements, sorted;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		elements = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			elements[i] = Integer.parseInt(st.nextToken());
		}

		sorted = new long[n];
		divide(0, n - 1);
		System.out.println(ans);

	}

	private static void divide(int low, int high) {

		if (low < high) {
			int mid = (low + high) / 2;

			divide(low, mid);
			divide(mid + 1, high);

			merge(low, mid, high);
		}
	}

	private static void merge(int low, int mid, int high) {
		int i = low; // left start index
		int j = mid + 1; // right start index
		int k = low; // sorted array index

		while (i <= mid && j <= high) {
			if (elements[i] <= elements[j]) {
				sorted[k] = elements[i];
				i++;
			} else { // elements[i] > elements[j]
				sorted[k] = elements[j];
				j++;
				ans += (mid + 1 - i); // counting the number of operation
			}
			k++;
		}

		// processing remains
		while (i <= mid) {
			sorted[k] = elements[i];
			i++;
			k++;
		}

		while (j <= high) {
			sorted[k] = elements[j];
			j++;
			k++;
		}

		for (int m = low; m < high + 1; m++) {
			elements[m] = sorted[m];
		}

	}

}

// reference: https://loosie.tistory.com/328