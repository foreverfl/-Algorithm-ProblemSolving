package BOJ_Copied;

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

		int root = 0;
		list = new ArrayList[n];
		dp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
			int a = Integer.parseInt(st.nextToken());
			if (a == -1) {
				root = i;
			} else {
				list[a].add(i); // a -> parent, i -> child(current)
			}
		}
		int min = solve(root);
		System.out.println(min);
	}

	private static int solve(int idx) {
		for (int nxt : list[idx]) {
			dp[nxt] = 1 + solve(nxt); // top -> bottom
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

	private static class DepthComp implements Comparator<Integer> { // The value whose depth is deeper comes first.
		@Override
		public int compare(Integer o1, Integer o2) {
			return dp[o2] - dp[o1];
		}
	}
}

// reference: https://loosie.tistory.com/501
