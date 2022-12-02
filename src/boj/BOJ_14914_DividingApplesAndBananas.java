package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14914_DividingApplesAndBananas {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int tmp = Math.min(a, b);
		int divisor = 1;
		while (true) {
			if (divisor > tmp)
				break;

			if (a % divisor == 0 && b % divisor == 0) {
				sb.append(divisor + " " + a / divisor + " " + b / divisor).append('\n');
			}

			divisor++;
		}

		System.out.println(sb.toString());
	}

}
