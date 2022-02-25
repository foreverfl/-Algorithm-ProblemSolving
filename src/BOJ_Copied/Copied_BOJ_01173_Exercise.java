package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01173_Exercise {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // exercise time
		int m = Integer.parseInt(st.nextToken()); // minimum pulse(the first pulse)
		int M = Integer.parseInt(st.nextToken()); // maximum pulse
		int T = Integer.parseInt(st.nextToken()); // +
		int R = Integer.parseInt(st.nextToken()); // -

		int count = 0;
		int time = 0;
		int current = m;

		while (count < N) {
			if (current + T <= M) {
				count++;
				time++;
				current += T;
			} else {
				if ((current - R) < m) {
					time++;
					current = m;
				} else {
					time++;
					current -= R;
				}
			}

			if (current + T > M && current == m) {
				System.out.println("-1");
				return;
			}
		}
		System.out.println(time);
	}

}

// reference: https://ukyonge.tistory.com/99
