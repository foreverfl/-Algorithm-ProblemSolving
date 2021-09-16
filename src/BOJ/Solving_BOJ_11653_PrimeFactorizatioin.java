package BOJ;

import java.util.Scanner;

public class Solving_BOJ_11653_PrimeFactorizatioin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if (num <= 1) {
			return;
		}

		boolean[] arr = new boolean[num + 1]; // true �̸� �ش� �ε��� �Ҽ�.
		arr[0] = arr[1] = false;
		for (int i = 2; i <= num; i += 1) {
			arr[i] = true;
		}

		// 2 ���� ���ڸ� Ű������ ������� ����(false �Ҵ�)
		for (int i = 2; i * i <= num; i += 1) {
			for (int j = i * i; j <= num; j += i) {
				arr[j] = false; // 2�� ������ 2�� ��� false
			}
		}
		System.out.println("Prime number list from 2 to " + num + " : ");
		for (int i = 0; i <= num; i += 1) {
			if (true == arr[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}
