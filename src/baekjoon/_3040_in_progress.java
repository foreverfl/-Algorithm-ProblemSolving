package baekjoon;

import java.util.Scanner;

public class _3040_in_progress {

	static int[] arr;
	static int[] answer;
	static int[] numbers;
	 // 두 메쏘드에서 모두 배열을 사용하려고 main 메쏘드 바깥에 배열 선언

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		numbers = new int[7];
		answer = new int[7];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		Combination(0, 0, 0);
		for (int i : answer) {
			System.out.println(i);
		}

	}

	static void Combination(int count, int start, int sum) {
		if (count == 7 && sum == 100) {
			answer = numbers.clone();
			return;
		} else if (count == 7) {
			return; // 7까지 카운팅했을 때 작동
		}
		for (int i = start; i < 9; i++) {
			numbers[count] = arr[i];
			Combination(count + 1, i + 1, sum + arr[i]);
		}
	}

}
