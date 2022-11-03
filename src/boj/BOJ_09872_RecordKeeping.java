package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_09872_RecordKeeping {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String[][] arr = new String[1001][3];

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
			arr[i][2] = st.nextToken();
			Arrays.sort(arr[i]);
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			int tmp = 0;
			for (int j = 0; j < N; j++) {
				if (arr[i][0].equals(arr[j][0]) && arr[i][1].equals(arr[j][1]) && arr[i][2].equals(arr[j][2]))
					tmp++;

				ans = Math.max(ans, tmp);
			}

		}

		System.out.print(ans);
	}

}

// reference: https://cocoon1787.tistory.com/295
