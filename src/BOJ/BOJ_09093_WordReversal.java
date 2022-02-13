package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_09093_WordReversal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				StringBuilder sb = new StringBuilder(st.nextToken());
				String reverse = sb.reverse().toString();
				System.out.print(reverse + " ");
				sb.delete(0, sb.length());
			}
			System.out.println();
		}
	}

}
