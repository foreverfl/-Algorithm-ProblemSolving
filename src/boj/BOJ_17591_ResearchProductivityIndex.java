package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17591_ResearchProductivityIndex {

	private static int N;
	private static List<Double> list = new ArrayList<>();
	private static double dp[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		dp = new double[200][200];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			list.add(Double.parseDouble(st.nextToken()) * 0.01);
		}

		Collections.sort(list, Collections.reverseOrder());
		list.add(0, null);

		dp[0][0] = 1;
		for (int i = 1; i <= N; i++) {
			// 각 논문을 1개 선택하고 그 논문이 선택되지 않을 가능성을 dp 배열의 첫 열에 넣는다.
			dp[i][0] = dp[i - 1][0] * (1 - list.get(i));
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				// (기존 dp값 * 해당 논문이 선택될 가능성) + (기존 dp값 * 해당 논문이 선택되지 않을 가능성) 
				dp[i][j] = dp[i - 1][j - 1] * (list.get(i)) + dp[i - 1][j] * (1 - list.get(i));
			}
		}

		double res = 0;
		for (int i = 1; i <= N; i++) {
			// ans는 RPI를 나타낸다.
			double ans = 0;
			for (int j = 1; j <= i; j++) {
				ans += dp[i][j] * Math.pow(j, j * 1.0 / (1.0 * i));
			}
			// 최대값을 선택한다.
			res = Math.max(res, ans);
		}

		System.out.printf("%.10f\n", res);
	}
}

// reference: https://codeantenna.com/a/RSSIcYamcW
