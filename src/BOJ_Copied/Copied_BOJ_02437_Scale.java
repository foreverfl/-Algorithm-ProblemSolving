package BOJ_Copied;

import java.util.Arrays;
import java.util.Scanner;

public class Copied_BOJ_02437_Scale {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int min = 1;
		for (int i = 0; i < N; i++) {
			if (min < arr[i]) {
				break;
			}
			min += arr[i];
		}
		System.out.println(min);

	}

}

// reference: https://dundung.tistory.com/79
