package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01813_LogicProfessor {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[51];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			arr[input]++;
		}

		for (int i = N; i >= 0; i--) {
			if (arr[i] == i) {
				System.out.println(i);
				return;
			}
		}

		System.out.println(-1);
	}

}
