package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_01135_SpreadingNews {

	static List<Integer>[] list;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		list = new ArrayList[n];
		int rt = 0;
		dp = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
			int a = Integer.parseInt(st.nextToken());
			if (a == -1) {
				rt = i;
			} else {
				list[a].add(i);
			}
		}
		int min = solve(rt);
		System.out.println(min);
	}

	static int solve(int idx) {
		for (int nxt : list[idx]) {
			dp[nxt] = 1 + solve(nxt);
		}
		Collections.sort(list[idx], new DepthComp());
		int res = 0;
		for (int i = 0; i < list[idx].size(); i++) {
			int num = list[idx].get(i);
			dp[num] += i;
			res = Math.max(res, dp[num]);
		}
		return res;
	}

	static class DepthComp implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return dp[o2] - dp[o1];
		}
	}
}

// reference: https://loosie.tistory.com/501
