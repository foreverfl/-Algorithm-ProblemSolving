package BOJ;

import java.util.Scanner;

public class Copied_BOJ_14659_HanjoRanking {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int count = 0;
		int result = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			count = 0; // 초기화
			for (int j = i + 1; j < N; j++) { // 'j = i'로 시작하면 안 된다.
				if (arr[i] > arr[j]) {
					count++;
				} else {
					break;
				}
			}
			result = Math.max(result, count);
		}

		System.out.println(result);

	}

}