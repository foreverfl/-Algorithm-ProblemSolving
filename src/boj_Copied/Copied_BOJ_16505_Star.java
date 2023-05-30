package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Copied_BOJ_16505_Star {

	private static char[][] field;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		field = new char[(int) Math.pow(2, n)][(int) Math.pow(2, n)];

		for (int i = 0; i < (int) Math.pow(2, n); i++)
			Arrays.fill(field[i], ' ');

		recur(0, 0, 0);

		for (int i = 0; i < (int) Math.pow(2, n); i++) {
			for (int j = 0; j < (int) Math.pow(2, n) - i; j++)
				sb.append(field[i][j]);
			if (i != (int) Math.pow(2, n) - 1)
				sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void recur(int depth, int x, int y) {
		if (depth == n) {
			field[y][x] = '*';
			return;
		}
		int d = (int) Math.pow(2, depth);
		recur(depth + 1, x, y);
		recur(depth + 1, x + d, y);
		recur(depth + 1, x, y + d);
	}

}

// reference: https://dalconbox.com/182?category=1003524