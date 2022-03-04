package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11509_BurstingBalloon {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] != 0) {
				int arrow_first = arr[i];
				cnt++;
				for (int j = i; j < N; j++) {
					if (arrow_first - 1 == arr[j]) {
						arr[j] = 0;						
					}
				}
			}
		}

		System.out.println(cnt);

	}

}
