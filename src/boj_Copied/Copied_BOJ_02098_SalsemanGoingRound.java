package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_02098_SalsemanGoingRound {

	static int n;
	static int[][] map;
	static int[][] dp;
	static final int INF = 11000000; // MAX : 11,000,000

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][(1 << n) - 1];
		// the reason subtract - 1.
		// 1 << 5 = 100000(2) -> what we need : 11111(2)

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// initializing the array of the DP
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], INF);
		}

		System.out.println(dfs(0, 1));
	}

	// starting from the 0st city
	private static int dfs(int city, int visitBitmask) {// city: city index now located, visitBitMask: visited
														// city(binary)

		if(visitBitmask == (1 << n) - 1) {	// If all cities is visited.
			if(map[city][0] == 0) {
				return INF;
			}
			
			return map[city][0];
		}

		if (dp[city][visitBitmask] != INF) { // If value of DP exits.
			return dp[city][visitBitmask];
		}

		for (int i = 0; i < n; i++) {
			if ((visitBitmask & (1 << i)) == 0 && map[city][i] != 0) {
				dp[city][visitBitmask] = Math.min(dp[city][visitBitmask],
						dfs(i, visitBitmask | (1 << i)) + map[city][i]);
			}
		}

		return dp[city][visitBitmask];
	}
}

// reference: https://maivve.tistory.com/306