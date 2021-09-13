package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _3040_PATULJCI_in_progress {

	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int arr[] = new int[10];
		int arr[] = {1, 2, 3};
		System.out.println(combination(arr, 3, 2));
		for (int i = 0; i < 10; i++) {
			
		}
	}

	public static int combination(int[] arr, int n, int r) {
		if (r == 0 || n == r) {
			return 1;
		} else {
			return combination(arr, n - 1, r - 1) + combination(arr, n - 1, r);
		}

	}
}
