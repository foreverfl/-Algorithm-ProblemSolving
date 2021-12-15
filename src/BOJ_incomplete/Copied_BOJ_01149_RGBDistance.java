package BOJ_incomplete;

import java.util.Scanner;

public class Copied_BOJ_01149_RGBDistance {

	final static int Red = 0;
	final static int Green = 1;
	final static int Blue = 2;

	static int[][] Cost;
	static int[][] DP; // saving accumulated values, searching

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Cost = new int[N][3];
		DP = new int[N][3];

		for (int i = 0; i < N; i++) {
			Cost[i][Red] = sc.nextInt();
			Cost[i][Green] = sc.nextInt();
			Cost[i][Blue] = sc.nextInt();
		}

		// Initializing the arrays 'cost'
		DP[0][Red] = Cost[0][Red];
		DP[0][Green] = Cost[0][Green];
		DP[0][Blue] = Cost[0][Blue];

		System.out.print(Math.min(Paint_cost(N - 1, Red), Math.min(Paint_cost(N - 1, Green), Paint_cost(N - 1, Blue))));
	}

	static int Paint_cost(int N, int color) {

		
		if (DP[N][color] == 0) { // unless the arrays searched

			// According to the 'color' it saves the current house's cost and the succeeding
			// minimum value to the array 'DP'.
			if (color == Red) {
				DP[N][Red] = Math.min(Paint_cost(N - 1, Green), Paint_cost(N - 1, Blue)) + Cost[N][Red];
			} else if (color == Green) {
				DP[N][Green] = Math.min(Paint_cost(N - 1, Red), Paint_cost(N - 1, Blue)) + Cost[N][Green];
			} else {
				DP[N][Blue] = Math.min(Paint_cost(N - 1, Red), Paint_cost(N - 1, Green)) + Cost[N][Blue];
			}

		}
		/*
		 * in case of the 'Red' �� Cost[N][0] = min( Cost[N-1][1], Cost[N-1][2] ) +
		 * Cost[N][0]
		 * 
		 * in case of the 'Green' �� Cost[N][1] = min( Cost[N-1][0], Cost[N-1][2] ) +
		 * Cost[N][1]
		 * 
		 * in case of the 'Blue' �� Cost[N][2] = min( Cost[N-1][0], Cost[N-1][1] ) +
		 * Cost[N][2]
		 */
		return DP[N][color];
	}
}