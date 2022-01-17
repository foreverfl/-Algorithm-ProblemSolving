package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Copied_BOJ_04195_FriendsNetwork {

	static int[] parent; // root node array
	static int[] level; // the number of each levels

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int F = Integer.parseInt(br.readLine());

			parent = new int[F * 2];
			level = new int[F * 2];
			for (int i = 0; i < F * 2; i++) {
				parent[i] = i;
				level[i] = 1;
			}

			int idx = 0;
			Map<String, Integer> map = new HashMap<>();

			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();

				if (!map.containsKey(a)) {
					map.put(a, idx++);
				}

				if (!map.containsKey(b)) {
					map.put(b, idx++);
				}

				sb.append(union(map.get(a), map.get(b)) + "\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static int union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) { // always x < y
			parent[y] = x;
			level[x] += level[y];

			level[y] = 1; 
		}

		return level[x];
	}

}

// reference: https://steady-coding.tistory.com/111
