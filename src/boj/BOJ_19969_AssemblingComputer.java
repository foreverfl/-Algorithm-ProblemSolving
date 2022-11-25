package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19969_AssemblingComputer {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());
		int a3 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int b1 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		int b3 = Integer.parseInt(st.nextToken());

		int ans = 0;
		// a1 - b1 조립
		if (a1 >= b1) {
			// 조립
			ans += b1;

			// 남은 부품
			a1 = a1 - b1;
			b1 = 0;
		} else {
			ans += a1;
			b1 = b1 - a1;
			a1 = 0;
		}

		// a2 - b2 조립
		if (a2 >= b2) {
			// 조립
			ans += b2;

			// 남은 부품
			a2 = a2 - b2;
			b2 = 0;
		} else {
			ans += a2;
			b2 = b2 - a2;
			a2 = 0;
		}

//		System.out.println(a1 + " " + a2 + " " + a3);
//		System.out.println(b1 + " " + b2 + " " + b3);

		// a3 - b1 조립
		while (true) {
			if (b1 == 0 || a3 == 0)
				break;

			a3--;
			b1--;
			ans++;

		}

		// a3 - b2 조립
		while (true) {
			if (b2 == 0 || a3 == 0)
				break;

			a3--;
			b2--;
			ans++;
		}

		// b3 - a1 조립
		while (true) {
			if (a1 == 0 || b3 == 0)
				break;

			b3--;
			a1--;
			ans++;
		}

		// b3 - a2 조립
		while (true) {
			if (a2 == 0 || b3 == 0)
				break;

			b3--;
			a2--;
			ans++;
		}

//		System.out.println(a1 + " " + a2 + " " + a3);
//		System.out.println(b1 + " " + b2 + " " + b3);

		if (a3 >= b3) {
			ans += b3;
		} else {
			ans += a3;
		}

		System.out.println(ans);

	}

}
