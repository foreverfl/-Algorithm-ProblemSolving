package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_11722_DecreasingPartOfProgression {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] d = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		d[1] = 1;

		for (int i = 2; i <= N; i++) {
			d[i] = 1;

			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j] && d[i] <= d[j])
					d[i] = d[j] + 1;
				else if (arr[i] == arr[j])
					d[i] = d[j];
			}
		}

		int max = 0;

		for (int i = 1; i <= N; i++)
			max = Math.max(d[i], max);

		System.out.println(max);
	}
}

// reference: https://developer-mac.tistory.com/72