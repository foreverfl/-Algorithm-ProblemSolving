package baekjoon;

import java.util.Scanner;

public class _3040_in_progress {

	static int[] arr;
	static int[] answer;
	static int[] numbers;
	 // �� �޽�忡�� ��� �迭�� ����Ϸ��� main �޽�� �ٱ��� �迭 ����

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
			return; // 7���� ī�������� �� �۵�
		}
		for (int i = start; i < 9; i++) {
			numbers[count] = arr[i];
			Combination(count + 1, i + 1, sum + arr[i]);
		}
	}

}
