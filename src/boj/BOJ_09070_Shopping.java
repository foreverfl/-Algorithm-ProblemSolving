package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_09070_Shopping {

	private static class Fish implements Comparable<Fish> {
		int W;
		int C;
		double ratio;

		public Fish(int w, int c, double ratio) {
			super();
			W = w;
			C = c;
			this.ratio = ratio;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.ratio > o.ratio) {
				return -1;
			} else if (this.ratio < o.ratio) {
				return 1;
			} else if (this.ratio == o.ratio) {
				return this.C - o.C;
			}
			return 0;
		}

		@Override
		public String toString() {
			return Integer.toString(C);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			List<Fish> list = new ArrayList<>();

			while (N-- > 0) {
				st = new StringTokenizer(br.readLine());
				int W = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				double ratio = (double) W / C;
				Fish fish = new Fish(W, C, ratio);
				list.add(fish);

			}

			Collections.sort(list);

			sb.append(list.get(0) + "\n");
		}

		System.out.println(sb.toString().trim());
	}
}
