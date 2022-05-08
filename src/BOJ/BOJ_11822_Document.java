package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11822_Document {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][5];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int day = 0;
		int i = 0;
		loop: while (true) {
			
			for (int j = 0; j < 5; j++) {
				day++;

				if (arr[i][j] == 1 && i == N - 1)
					break loop;

				if (arr[i][j] == 1) {
					i++; // changing an officer
				}
			}
			day = day + 2; // weekend
		}

		System.out.println(day);
	}

}
