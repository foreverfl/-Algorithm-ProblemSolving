package BOJ_Copied;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Copied_BOJ_01072_Game {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		long Z = 100 * Y / X;
		if (Z >= 99) { // The 'Z' cannot be 100%.
			bw.write("-1");
		} else {
			long start = 0;
			long end = Integer.MAX_VALUE;
			while (start < end) {
				long mid = (start + end) / 2;
				long result = 100 * (Y + mid) / (X + mid);
				if (result > Z) {
					end = mid;
				} else {
					start = mid + 1;
				}
			}
			bw.write(String.valueOf(end));
		}
		bw.flush();
	}
}

// reference: https://kwoncorin.tistory.com/111