package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01453_PartTimerOfInternetCaffee {

	static boolean[] seat = new boolean[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int reject = 0;
		
		st = new StringTokenizer(br.readLine());
		while (N-- > 0) {
			
			int visitor = Integer.parseInt(st.nextToken());
			
			if (seat[visitor]) {
				reject++;
			}
			
			if (!seat[visitor]) {
				seat[visitor] = true;
			}

			
		}

		System.out.println(reject);

	}

}
