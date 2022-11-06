package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10103_DoubleDice {

	private static int A = 100, B = 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int dice1 = Integer.parseInt(st.nextToken());
			int dice2 = Integer.parseInt(st.nextToken());

			if (dice1 > dice2) {
				B = B - dice1;
			} else if (dice1 < dice2) {
				A = A - dice2;
			}
		}

		System.out.println(A + "\n" + B);
	}
}
