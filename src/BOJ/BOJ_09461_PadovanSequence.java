package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_09461_PadovanSequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long[] arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;

		for (int i = 6; i <= 100; i++) {
			arr[i] = arr[i - 5] + arr[i - 1];
		}

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(arr[N]).append('\n');
		}

		System.out.println(sb.toString());
	}

}
