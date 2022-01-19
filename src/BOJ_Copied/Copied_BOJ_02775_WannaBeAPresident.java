package BOJ_Copied;

import java.util.Scanner;

public class Copied_BOJ_02775_WannaBeAPresident {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// creating the apart
		int[][] APT = new int[15][15];

		for (int i = 0; i < 15; i++) {
			APT[i][1] = 1; // floor i, unit 1
			APT[0][i] = i; // floor 0, unit i
		}

		for (int i = 1; i < 15; i++) { // to the floor 14

			for (int j = 2; j < 15; j++) { // from unit 2 to unit 14
				APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
			}
		}

		// test case
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(APT[k][n]);
		}
	}

}
