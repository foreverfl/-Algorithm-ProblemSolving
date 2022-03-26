package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Copied_BOJ_14267_CompanyCulture {

	static ArrayList<Integer>[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		dp = new int[n + 1];
		arr = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int input = Integer.parseInt(st.nextToken());
			
			if(input == -1)
				continue;
			
			arr[input].add(i);
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			dp[i] = dp[i] + w;
		}

		dfs(1, 0);

		for (int i = 1; i <= n; i++) {
			sb.append(dp[i] + " ");
		}

		System.out.println(sb.toString());

	}

	private static void dfs(int idx, int praise) {
		dp[idx] = dp[idx] + praise;
		
		for (int i = 0; i < arr[idx].size(); i++) {
			dfs(arr[idx].get(i), dp[idx]);
		}
	}

}

// reference: https://red-tiger.tistory.com/8
