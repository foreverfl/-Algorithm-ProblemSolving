package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01233_Dice {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int S1 = Integer.parseInt(st.nextToken());
		int S2 = Integer.parseInt(st.nextToken());
		int S3 = Integer.parseInt(st.nextToken());

		int max = S1 + S2 + S3;
		int min = 3; // 1 + 1 + 1

		int[] check_arr = new int[max + 1];

		for (int i = 1; i <= S1; i++) {
			for (int j = 1; j <= S2; j++) {
				for (int k = 1; k <= S3; k++) {
					for (int check = min; check <= max; check++) {
						if (i + j + k == check) {
							check_arr[check]++;
						}
					}
				}
			}
		}

		int max_tmp = Integer.MIN_VALUE;
		for (int i = min; i <= max; i++) {
			if (check_arr[i] > max_tmp)
				max_tmp = check_arr[i];
		}

		for (int i = min; i <= max; i++) {
			if (check_arr[i] == max_tmp) {
				System.out.println(i);
				break;
			}
		}

	}

}
