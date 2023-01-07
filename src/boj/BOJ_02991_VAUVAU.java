package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02991_VAUVAU {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		boolean[] dog1 = new boolean[2001];
		boolean[] dog2 = new boolean[2001];

		int idx = 1;
		loop: while (true) {
			for (int i = 0; i < A; i++) {
				dog1[idx++] = true;
				if (idx > 2000) {
					break loop;
				}
			}
			for (int i = 0; i < B; i++) {
				dog1[idx++] = false;
				if (idx > 2000) {
					break loop;
				}
			}
		}

		idx = 1;
		loop: while (true) {
			for (int i = 0; i < C; i++) {
				dog2[idx++] = true;
				if (idx > 2000) {
					break loop;
				}
			}
			for (int i = 0; i < D; i++) {
				dog2[idx++] = false;
				if (idx > 2000) {
					break loop;
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (dog1[arr[i]] && dog2[arr[i]]) {
				sb.append(2).append('\n');
			} else if (dog1[arr[i]] ^ dog2[arr[i]]) {
				sb.append(1).append('\n');
			} else if (!dog1[arr[i]] && !dog2[arr[i]]) {
				sb.append(0).append('\n');
			}
		}

		System.out.println(sb.toString());

	}

}
