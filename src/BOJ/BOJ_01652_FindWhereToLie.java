package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01652_FindWhereToLie {

	static int cnt_horizontal, cnt_vertical;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// input
		String[] str = new String[N];

		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}

		// counting horizontally
		for (int i = 0; i < N; i++) {
			count_horizontal(str[i]);
		}

		// vertical to horizontal
		String[] reverse = new String[N];
		for (int i = 0; i < N; i++) { // initialization
			reverse[i] = "";
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				reverse[i] += str[j].charAt(i);
			}
		}

		// counting vertically
		for (int i = 0; i < N; i++) {
			count_vertical(reverse[i]);
		}

		System.out.println(cnt_horizontal + " " + cnt_vertical);

	}

	private static void count_horizontal(String str) {
		String[] tmp = str.split("X");
		for (int j = 0; j < tmp.length; j++) {
			if (tmp[j].length() >= 2) {
				cnt_horizontal++;
			}
		}
	}

	private static void count_vertical(String str) {
		String[] tmp = str.split("X");
		for (int j = 0; j < tmp.length; j++) {
			if (tmp[j].length() >= 2) {
				cnt_vertical++;
			}
		}
	}
}
