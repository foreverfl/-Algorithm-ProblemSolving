package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02490_PlayingYut {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[][] yut = new int[3][4];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				yut[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		for (int i = 0; i < 3; i++) {
			int sum = 0;
			for (int j = 0; j < 4; j++) {
				sum += yut[i][j];

			}
			String res = decide(sum);
			sb.append(res).append('\n');
		}

		System.out.println(sb.toString());

	}

	private static String decide(int num) {
		if (num == 0)
			return "D";
		else if (num == 1)
			return "C";
		else if (num == 2)
			return "B";
		else if (num == 3)
			return "A";
		else if (num == 4)
			return "E";

		return null;
	}

}
