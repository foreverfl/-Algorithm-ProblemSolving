package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11509_BurstingBalloon {

	static int[] arrowHeight = new int[1000002]; // The '1000001' causes the 'out of bound' exception

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0, height = 0;
		for (int i = 0; i < N; i++) {

			height = arr[i];

			if (arrowHeight[height + 1] == 0) {
				arrowHeight[height]++;
				cnt++;
				
			} else {

				arrowHeight[height + 1]--;
				arrowHeight[height]++;

			}
		}

		System.out.println(cnt);

	}

}

// reference: https://jaimemin.tistory.com/507