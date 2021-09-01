package baekjoon;

import java.util.Scanner;

public class _3040_in_progress {

	static int[] arr;
	static int[] ans;
	static int[] numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		numbers = new int[7];
		ans = new int[7];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		Combination(0, 0, 0);
		for (int i : ans) {
			System.out.println(i);
		}

	}

	static void Combination(int cnt, int start, int sum) {
		if (cnt == 7 && sum == 100) {
			ans = numbers.clone();
			return;
		} else if (cnt == 7) {
			return;
		}
		for (int i = start; i < 9; i++) {
			numbers[cnt] = arr[i];
			Combination(cnt + 1, i + 1, sum + arr[i]);
		}
	}

}
