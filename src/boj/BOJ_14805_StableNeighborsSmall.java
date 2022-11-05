package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14805_StableNeighborsSmall {

	private static class Mane implements Comparable<Mane> {
		char color;
		int cnt;

		public Mane() {
		}

		public Mane(char color, int cnt) {
			this.color = color;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Mane o) {
			return this.cnt - o.cnt;
		}

		@Override
		public String toString() {
			return "color=" + color + ", cnt=" + cnt;
		}

		public static Mane copy(Mane original) {
			Mane copy = new Mane();
			copy.color = original.color;
			copy.cnt = original.cnt;
			return copy;
		}

	}

	private static List<Mane> list = new ArrayList<>();

	private static int N, T;
	private static Mane red, orange, yellow, green, blue, violet;
	private static String ans = "";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			red = new Mane('R', Integer.parseInt(st.nextToken()));
			orange = new Mane('O', Integer.parseInt(st.nextToken()));
			yellow = new Mane('Y', Integer.parseInt(st.nextToken()));
			green = new Mane('G', Integer.parseInt(st.nextToken()));
			blue = new Mane('B', Integer.parseInt(st.nextToken()));
			violet = new Mane('V', Integer.parseInt(st.nextToken()));
			list.add(Mane.copy(red));
			list.add(Mane.copy(yellow));
			list.add(Mane.copy(blue));
//			list.add(orange);
//			list.add(green);
//			list.add(violet);

			sb.append("Case #" + i + ": " + solve().toString());
			sb.append('\n');
			list.clear();
		}
		System.out.println(sb.toString().trim());
	}

	public static StringBuilder solve() {

		StringBuilder ans = new StringBuilder();

		int cnt = (red.cnt + yellow.cnt + blue.cnt) / 2;
		if (cnt < red.cnt || cnt < yellow.cnt || cnt < blue.cnt)
			return ans.append("IMPOSSIBLE");
		if (red.cnt < 0 || yellow.cnt < 0 || blue.cnt < 0)
			return ans.append("IMPOSSIBLE");

		cnt = (red.cnt + yellow.cnt + blue.cnt + 1) / 2;

		Collections.sort(list);
		int idx = 0;

		for (int i = 0; i < cnt; i++) {
			while (list.get(idx).cnt <= 0)
				idx++;

			ans.append(list.get(idx).color);
			list.get(idx).cnt--;
			switch (list.get(idx).color) {
			case 'R':
				red.cnt--;
				break;
			case 'Y':
				yellow.cnt--;
				break;
			case 'B':
				blue.cnt--;
				break;
			}
		}
		int ind = 1;
		while (0 < red.cnt + yellow.cnt + blue.cnt) {
			while (list.get(idx).cnt <= 0)
				idx++;

			list.get(idx).cnt--;
			switch (list.get(idx).color) {
			case 'R':
				ans.insert(ind, "R");
				red.cnt--;
				break;
			case 'Y':
				ans.insert(ind, "Y");
				yellow.cnt--;
				break;
			case 'B':
				ans.insert(ind, "B");
				blue.cnt--;
				break;
			}
			ind += 2;
		}
		return ans;
	}

}

// reference: https://withhamit.tistory.com/134
