package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_23812_PrintingShell {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String... args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			print1(N);
			sb.append('\n');
		}
		for (int i = 0; i < N; i++) {
			print2(N);
			sb.append('\n');
		}
		for (int i = 0; i < N; i++) {
			print1(N);
			sb.append('\n');
		}
		for (int i = 0; i < N; i++) {
			print2(N);
			sb.append('\n');
		}
		for (int i = 0; i < N; i++) {
			print1(N);
			sb.append('\n');
		}

		System.out.println(sb.toString().trim());
	}

	private static void print1(int num) {
		for (int i = 0; i < num; i++) {
			sb.append("@");
		}
		for (int i = 0; i < num * 3; i++) {
			sb.append(" ");
		}
		for (int i = 0; i < num; i++) {
			sb.append("@");
		}
	}

	private static void print2(int num) {
		for (int i = 0; i < num * 5; i++) {
			sb.append("@");
		}
	}
}
