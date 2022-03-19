package BOJ_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Copied_BOJ_05568_PuttingCards {

	public static StringTokenizer stk;
	public static StringBuffer sb = new StringBuffer();
	public static HashSet<String> hashset = new HashSet<>();
	public static boolean[] visited;
	public static String[] card;
	public static int cnt = 0, n, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		card = new String[n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 1; i <= n; i++) {
			card[i] = br.readLine();
		}
		
		dfs(k, 1, "");
		
		System.out.println(hashset.size());
	}
	
	// k -> depth
	// idx -> for no repeat
	// str -> the variable to use	
	
	public static void dfs(int k, int idx, String str) {
		if (k == 0) {
			hashset.add(str); // Addition has to occur in this part.
			return;
		}
		
		if (idx > n) {
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(k - 1, i, str + card[i]);
				visited[i] = false;
			}
		}
	}
}

// reference: https://sophia2730.tistory.com/entry/Algorithm-%EB%B0%B1%EC%A4%805568-%EC%B9%B4%EB%93%9C-%EB%86%93%EA%B8%B0