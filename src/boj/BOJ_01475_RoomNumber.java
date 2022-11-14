package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01475_RoomNumber {

	private static int[] set = new int[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();

		int res = 0;
		for (int i = 0; i < N.length(); i++) {
			int now = N.charAt(i) - '0';

			if (isPossible(now)) {
				useSet(now);
			} else {
				makeSet();
				useSet(now);
				res++;
			}
		}

		System.out.println(res);
	}

	private static boolean isPossible(int now) {
		if (now == 6) {
			if (set[6] == 0 && set[9] == 0) {
				return false;
			}
		} else if (now == 9) {
			if (set[6] == 0 && set[9] == 0) {
				return false;
			}
		} else {
			if (set[now] == 0)
				return false;
		}

		return true;
	}

	private static void useSet(int now) {
		if (now == 6) {
			if (set[6] != 0) {
				set[6]--;
			} else if (set[9] != 0) {
				set[9]--;
			}
		} else if (now == 9) {
			if (set[9] != 0) {
				set[9]--;
			} else if (set[6] != 0) {
				set[6]--;
			}
		} else {
			set[now]--;
		}

	}

	private static void makeSet() {
		for (int i = 0; i < 10; i++) {
			set[i] += 1;
		}
	}
}
