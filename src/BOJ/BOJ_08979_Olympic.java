package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_08979_Olympic {

	static class Nation implements Comparable<Nation> {
		int country;
		int gold;
		int silver;
		int bronze;

		Nation(int country, int gold, int silver, int bronze) {
			this.country = country;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public int compareTo(Nation o) {
			if (this.gold == o.gold) {
				if (this.silver == o.silver) {
					return o.bronze - this.bronze;
				}
				return o.silver - this.silver;
			}
			return o.gold - this.gold;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Nation[] arr = new Nation[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int country = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());

			arr[i] = new Nation(country, gold, silver, bronze);
		}

		Arrays.sort(arr);

		Map<Integer, Integer> map = new HashMap<>();

		int rank = 1;
		Nation before = arr[0];
		for (int i = 0; i < N; i++) {
			Nation now = arr[i];
			int country = now.country;

			if (i == 0) 
				map.put(country, rank);
			
			if (before.gold == now.gold && before.silver == now.silver && before.bronze == now.bronze) {
				map.put(country, map.get(before.country));
			} else {
				map.put(country, rank);
			}

			rank++;
			before = now;
		}

			System.out.println(map.get(K));

	}

}
