package BOJ;

import java.util.Scanner;

public class BOJ_01764_PersonWhoIsStrange {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int T = 0;
		int count = 0;
		if (N > M) {
			T = N;
		} else if (M > N) {
			T = M;
		}

		String[] cantHear = new String[N];
		String[] cantSee = new String[M];
		String[] answer = new String[T];

		for (int i = 0; i < N; i++) {
			cantHear[i] = sc.next();
		}

		for (int i = 0; i < M; i++) {
			cantSee[i] = sc.next();
		}

		for (int i = 0, k = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cantHear[i].equals(cantSee[j])) {
					answer[i] = cantHear[i];
				}
			}
		}
		for(int i=0; i<)
		System.out.println(count);
	}
}
