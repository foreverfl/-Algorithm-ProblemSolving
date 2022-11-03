package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_09375_Incognito {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			HashMap<String, Integer> hashmap = new HashMap<>();

			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String clothes = st.nextToken();
				String kind = st.nextToken();

				hashmap.put(kind, hashmap.getOrDefault(kind, 0) + 1);
			}

			int sum = 1;
			for (String key : hashmap.keySet()) {
				sum *= hashmap.get(key) + 1;
			}

			sb.append(sum - 1).append('\n');
		}

		System.out.println(sb.toString());

	}

}
