package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01009_ProcessingVariance {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int result = 1;

			for (int j = 0; j < b; j++) {
				result = (result * a) % 10;
			}

			if (result == 0)
				sb.append(10).append('\n');
			else
				sb.append(result).append('\n');

		}

		System.out.println(sb.toString());
	}

}

// reference: https://umilove98.tistory.com/47
