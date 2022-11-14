package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02522_PrintingStar12 {

	/*
	 * 1. 3줄까지 입력받는 모양 만들기
	 * 2. 나머지 아래 모양 만들기
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int blank = N;
		int star = 0;
		for (int i = 1; i <= N; i++) {
			--blank;
			++star;
			for (int j = 0; j < blank; j++) {
				System.out.print(" ");
			}

			for (int j = 0; j < star; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		blank = 0;
		star = N;
		for (int i = 1; i <= N - 1; i++) {
			++blank;
			--star;
			for (int j = 0; j < blank; j++) {
				System.out.print(" ");
			}

			for (int j = 0; j < star; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
