package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_20709_Kates2021Celebration {
	static class Balloon implements Comparable<Balloon> {
		public int idx;
		public int price;
		public String contents;

		public Balloon(int idx, int price, String contents) {
			this.idx = idx;
			this.price = price;
			this.contents = contents;

		}

		@Override
		public int compareTo(Balloon o) {
			return this.price - o.price; // ascending order: this.price > o.price
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		ArrayList<Balloon> balloon = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = i + 1;
			int price = Integer.parseInt(st.nextToken());
			String contents = st.nextToken();

			if (balloonValidation(contents))
				balloon.add(new Balloon(idx, price, contents));
		}

		Collections.sort(balloon);
		if (balloon.isEmpty())
			System.out.println("0");
		else
			System.out.println(balloon.get(0).idx);

	}

	private static boolean balloonValidation(String str) {
		int check_2 = 0;
		int check_0 = 0;
		int check_1 = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '2') {
				check_2++;
			} else if (str.charAt(i) == '0') {
				check_0++;
			} else if (str.charAt(i) == '1') {
				check_1++;
			}
		}
		if (check_2 >= 2 && check_0 >= 1 && check_1 >= 1) {
			return true;
		} else
			return false;

	}

}
