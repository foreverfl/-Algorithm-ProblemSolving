package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_01417_VotingCongressman {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N - 1];
		int dasom = Integer.parseInt(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int ans = 0;

		while (true) {
			boolean flag = true;
			Arrays.sort(arr);

			for (int i = arr.length - 1; i >= 0; i--) {
				if (arr[i] >= dasom) {
					arr[i]--;

					dasom++;
					ans++;
					flag = false;
					break;
				} 
			}

			if (flag)
				break;
		}

		System.out.println(ans);
	}

}
