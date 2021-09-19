package BOJ;

import java.util.Scanner;

public class Copying_BOJ_11729_TowerOfHanoi {

	public static StringBuilder sb = new StringBuilder();

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();

		sb.append((int) (Math.pow(2, N) - 1)).append('\n');

		Hanoi(N, 1, 2, 3);
		System.out.println(sb);

	}

	public static void Hanoi(int N, int start, int mid, int to) {
		if (N == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		// STEP1: in case of the number of 'N' is 'N-1', A ¡æ B
		Hanoi(N - 1, start, to, mid); 

		// STEP2: in case of the number of 'N' is '1', A ¡æ C
		sb.append(start + " " + to + "\n");

		// STEP3: in case of the number of 'N' is 'N-1', B ¡æ C
		Hanoi(N - 1, mid, start, to);

	}
}
