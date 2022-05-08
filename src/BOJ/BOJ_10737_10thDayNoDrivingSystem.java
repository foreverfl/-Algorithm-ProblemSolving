package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10737_10thDayNoDrivingSystem {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[5];

		int ans = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (arr[i] == N)
				ans++;
		}

		System.out.println(ans);
	}

}
