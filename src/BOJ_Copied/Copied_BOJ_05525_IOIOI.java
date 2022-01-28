package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_05525_IOIOI {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		int[] check = new int[M]; // It is the array to count the 'OI'.

		int ans = 0;

		for (int i = 1; i < M - 1; i++) {
			if (arr[i] == 'O' && arr[i + 1] == 'I') {
				check[i + 1] = check[i - 1] + 1;

				if (check[i + 1] >= N && arr[i - 2 * N + 1] == 'I')
					ans++;
			}
		}

		System.out.println(ans);
	}

}