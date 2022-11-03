package programmers_Copied;

public class Copied_Programmers_43105_IntegerTriangle {
	
	public static void main(String[] args) {

		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };

		int res = solution(triangle);

		System.out.println(res);
	}

	public static int solution(int[][] triangle) {

		int[][] dp = new int[triangle.length][triangle.length];
		dp[0][0] = triangle[0][0];

		for (int i = 1; i < triangle.length; i++) {

			dp[i][0] = triangle[i][0] + dp[i - 1][0];

			for (int j = 1; j < i + 1; j++) {
				dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
			}
		}

		int max = 0;
		for (int i = 0; i < dp[dp.length - 1].length; i++) {
			max = Math.max(dp[dp.length - 1][i], max);
		}

		int answer = max;
		return answer;
	}
}

// reference: https://velog.io/@devsh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A0%95%EC%88%98-%EC%82%BC%EA%B0%81%ED%98%95-with-Java