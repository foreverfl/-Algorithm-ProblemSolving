package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16786_SugorokuAndPieces {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (M-- > 0) {
			int idx = Integer.parseInt(st.nextToken());
			int tmp = arr[idx - 1] + 1;
			boolean isContained = false;

			for (int i = 0; i < N; i++) {
				if (arr[i] == tmp) {
					isContained = true;
				}
			}

			if (isContained) {
				continue;
			} else {
				arr[idx - 1]++;
			}

			for (int i = 0; i < N; i++) {
				if (arr[i] > 2019)
					arr[i] = 2019;
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

}
