package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01107_RemoteControl {

	static boolean[] broken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		broken = new boolean[10];

		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int num = Integer.parseInt(st.nextToken());
				broken[num] = true;
			}
		}

		int min_cnt = Math.abs(N - 100); 
		for (int i = 0; i <= 1000000; i++) {
			int len = check(i); // the number of pressing buttons 
			if (len > 0) {
				int press = Math.abs(N - i); 
				min_cnt = Math.min(min_cnt, len + press);
			}
		}

		System.out.print(min_cnt);

	}

	public static int check(int n) {
		if (n == 0) {
			if (broken[0]) {
				return 0;
			} else {
				return 1;
			}
		}
		
		int len = 0;
		while (n > 0) {
			if (broken[n % 10]) { 
				return 0;
			}
			n /= 10;
			len += 1; 
		}
		return len;
	}

}

// reference: https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-1107-%EB%A6%AC%EB%AA%A8%EC%BB%A8-java