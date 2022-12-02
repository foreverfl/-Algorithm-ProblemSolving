package programmers;

public class Programmers_12945_FibonacciNumber {

	public static void main(String[] args) {
		System.out.println(solution(3));
		System.out.println(solution(5));
	}

	public static int solution(int n) {
		int mod = 1234567;
		int[] dp = new int[100001];

		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= 100000; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
			dp[i] %= mod;
		}

		return dp[n];
	}

}
