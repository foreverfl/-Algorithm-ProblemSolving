package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_09076_AggregatingScore {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int[] arr = new int[5];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 5; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			int tmp_1 = arr[3];
			int tmp_2 = arr[1];
			int sum = 0;

			for (int i = 1; i < 4; i++) {
				sum += arr[i];
			}

			if (tmp_1 - tmp_2 >= 4)
				sb.append("KIN").append('\n');
			else
				sb.append(sum).append('\n');

		}

		System.out.println(sb.toString());
	}

}
