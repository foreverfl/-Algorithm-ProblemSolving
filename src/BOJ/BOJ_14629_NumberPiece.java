package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14629_NumberPiece {

	static boolean[] visited = new boolean[10];
	static long input;
	static int len;
	static long min_diff = Long.MAX_VALUE, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = Long.parseLong(br.readLine());
		len = Long.toString(input).length();

		if (len > 10) {
			System.out.print("9876543210");
			System.exit(0);
		}
		
		backTracking(0, "");

		System.out.print(ans);
	}

	public static void backTracking(int depth, String tmp) {
		if (depth == len) {
			long check = Math.abs(input - Long.parseLong(tmp));
			if (check < min_diff) {
				min_diff = check;
				ans = Long.parseLong(tmp);
			}
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				backTracking(depth + 1, tmp + Long.toString(i));
				visited[i] = false;
			}
		}
	}

}
