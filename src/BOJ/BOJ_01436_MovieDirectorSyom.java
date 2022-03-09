package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01436_MovieDirectorSyom {

	static long[] movie;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		movie = new long[N + 1];

		int tmp = 665;
		int idx = 1;
		while (movie[N] == 0) {
			tmp++;

			if (check(tmp)) {
				movie[idx] = tmp;
				idx++;
			}

		}

		System.out.println(movie[N]);
	}

	private static boolean check(int input) {
		String tmp = Integer.toString(input);
		for (int i = 0; i < tmp.length() - 2; i++) {
			if (tmp.charAt(i) == '6' && tmp.charAt(i + 1) == '6' && tmp.charAt(i + 2) == '6')
				return true;

		}

		return false;
	}

}
