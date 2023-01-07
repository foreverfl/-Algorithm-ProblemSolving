package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_26714_CountingPoint {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int divide = n / 10;

		int ans = 0;
		int idx = 0;
		while (true) {
			int check = 0;
			for (int i = 0; i < divide; i++) {
				if (str.charAt(idx++) == 'T') {
					check++;
				}
			}

			if (check == divide)
				ans++;

			if (idx == str.length())
				break;
		}

		System.out.println(ans);

	}

}
