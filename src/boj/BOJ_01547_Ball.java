package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01547_Ball {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int M = Integer.parseInt(br.readLine());

		int[] arr = new int[3 + 1];
		arr[1] = 1;

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int tmp_a = arr[a];
			int tmp_b = arr[b];
			arr[a] = tmp_b;
			arr[b] = tmp_a;
		}

		for (int i = 1; i <= 3; i++) {
			if (arr[i] == 1) {
				System.out.println(i);
				break;
			}
		}

	}

}
