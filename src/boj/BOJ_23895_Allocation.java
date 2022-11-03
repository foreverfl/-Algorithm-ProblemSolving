package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_23895_Allocation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] N = new int[T];
		int B = 0;
		int sum = 0;
		int cnt = 0;

		for (int i = 0; i < T; i++) {
			sum = 0;
			cnt = 0; // initialization
			StringTokenizer st = new StringTokenizer(br.readLine());

			N[i] = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] house = new int[N[i]];
			for (int j = 0; j < N[i]; j++) {
				house[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(house);

			for (int j = 0; j < N[i]; j++) {
				sum += house[j];
				if (sum > B) {
					break;
				}
				cnt++;
			}

			System.out.println("Case #" + (i + 1) + ": " + cnt);

		}

	}

}
