package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_01270_War_GainingTerritory {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			System.gc();
			TreeMap<Long, Integer> map = new TreeMap<>();
			long res = 0, idx = -1;

			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());

			for (int i = 0; i < T; i++) {
				long num = Long.parseLong(st.nextToken());
				if (map.containsKey(num)) {
					map.put(num, map.get(num) + 1);
				} else {
					map.put(num, 1);
				}

				long tmp = map.get(num);
				if (tmp > res) {
					idx = num;
					res = tmp;
				}
			}

			if (res > T / 2) {
				sb.append(idx).append('\n');
			} else {
				sb.append("SYJKGW").append('\n');
			}

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}

// reference: https://mangu.tistory.com/123, https://nahwasa.com/42
