package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_02188_AssigningBarn {

	static List<Integer>[] list;
	static boolean[] check;
	static int[] barn;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		check = new boolean[m + 1];
		barn = new int[m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			for (int j = 0; j < s; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			Arrays.fill(check, false); // initialization
			if (dfs(i))
				cnt++;
		}
		System.out.println(cnt);
	}

	static boolean dfs(int here) {
		for (int nxt : list[here]) {
			if (!check[nxt]) {
				check[nxt] = true;
				// vacant in this node or in inner node
				if (barn[nxt] == 0 || dfs(barn[nxt])) {
					barn[nxt] = here;
					return true;
				}
			}
		}
		return false;
	}
}

// reference: https://loosie.tistory.com/643
