package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14720_MilkFestival {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int now = 0;
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		while (N-- > 0) {
			int input = Integer.parseInt(st.nextToken());
			if (now == 0 && input == 0) {
				cnt++;
				now = 1;
			} else if (now == 1 && input == 1) {
				cnt++;
				now = 2;
			} else if (now == 2 && input == 2) {
				cnt++;
				now = 0;
			}

		}

		System.out.println(cnt);
	}

}
