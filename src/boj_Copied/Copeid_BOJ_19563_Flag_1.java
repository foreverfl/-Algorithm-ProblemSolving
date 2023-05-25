package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copeid_BOJ_19563_Flag_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Math.abs(Long.parseLong(st.nextToken()));
		long b = Math.abs(Long.parseLong(st.nextToken()));
		long c = Long.parseLong(st.nextToken());

		if (a + b <= c) {
			if ((a + b) % 2 == 0 && c % 2 == 0)
				System.out.println("YES");
			else if ((a + b) % 2 != 0 && c % 2 != 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		} else
			System.out.println("NO");

	}

}

// reference: https://kistone.tistory.com/30