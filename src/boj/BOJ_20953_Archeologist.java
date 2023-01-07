package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_20953_Archeologist {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(dolmen(a, b) + "\n");
		}

		bw.flush();
		bw.close();
	}

	public static long dolmen(int a, int b) {
		long ans = 0;
		ans = ((long) Math.pow((a + b), 2) * (a + b - 1)) / 2;

		return ans;
	}

}

// reference: https://sozerodev.tistory.com/183