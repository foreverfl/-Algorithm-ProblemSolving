package BOJ;

import java.util.Scanner;

public class Solving_BOJ_14659_HanjoRanking {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		int result[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

			}
			for (int k = 0; k < N; k++) {
				if (arr[i] > arr[j]) {
					result[i]++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.println(result[i]);
		}
	}

}