package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01592_YoungsikAndHisFriends {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] count = new int[N + 1];

		int ans = -1;
		int ball = 1; // start
		loop: while (true) {
			
			ans++;
			count[ball]++;
			
			for (int i = 0; i < count.length; i++) {
				if (count[i] == M)
					break loop;
			}
			
			if (count[ball] % 2 == 1) 
				ball = ball + L;
			else
				ball = ball - L;
			
			if (ball > N)
				ball = ball - N;

			if (ball <= 0)
				ball = N + ball;
			
		}

		System.out.println(ans);
	}

}
