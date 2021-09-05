package baekjoon;

import java.util.Scanner;

public class _9663 {

	public static int N;
	public static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			int[] column = new int[N + 1];
			column[1] = i;
			rowCheck(column, 1);
		}
		System.out.println(count);
	}

	public static void rowCheck(int[] column, int row) {
		if (row == N) {
			count++; // It will increase 1, if the condition is satisfied.
		} else {
			for (int i = 1; i <= N; i++) {
				column[row + 1] = i; // An value of the row is input from 1.
				if (isPossible(column, row + 1)) {
					rowCheck(column, row + 1);
				}
			}
		}
	}

	public static boolean isPossible(int[] column, int row) {
		for (int i = 1; i < row; i++) {
			if (column[i] == column[row]) // It checks whether the queens are in the same column.
				return false;

			if (Math.abs(i - row) == Math.abs(column[i] - column[row])) // It checks whether the queens are in the same diagonal line. 
				return false;
		}
		return true;
	}

}
