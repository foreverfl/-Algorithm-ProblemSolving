package Programmers;

public class Programmers_42898_OnesWayToSchool {

	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles_1 = { { 2, 2 } };
		int[][] puddles_2 = { { 1, 2 }, { 2, 1 } };
		int res = solution(m, n, puddles_2);
		System.out.print(res);

	}

	static final int mod = 1000000007;

	public static int solution(int m, int n, int[][] puddles) {

		int[][] dp = new int[m + 1][n + 1];

		dp[1][1] = 1;
		for (int i = 1; i <= m; i++) {
			loop: for (int j = 1; j <= n; j++) {
				if (i == 1 && j == 1)
					continue;

				for (int k = 0; k < puddles.length; k++) {
					if (i == puddles[k][0] && j == puddles[k][1])
						continue loop;
				}

				dp[i][j] = dp[i - 1][j] % mod + dp[i][j - 1] % mod;

			}
		}

		int ans = dp[m][n] % mod;
		return ans;
	}

}
