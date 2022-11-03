package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01069_ToHome {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		double dist = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
		double ans = dist; // on foot
		int cnt = (int) dist / D;
		// the remains
		dist -= cnt * D;

		if (cnt == 0) {
			// jumping once and walking(turning back)
			ans = Math.min(ans, (double) T + ((double) D - dist));
			// jumping two times(including turning)
			ans = Math.min(ans, 2.0 * (double) T);
		} else {
			// jumping cnt times and walking
			ans = Math.min(ans, (double) cnt * T + dist);
			// jumping cnt+1 times(including turning)
			ans = Math.min(ans, (double) ((cnt + 1) * T));
		}
		System.out.printf("%.13f", ans);
	}

}

// reference: https://mapocodingpark.blogspot.com/2020/05/1069.html
