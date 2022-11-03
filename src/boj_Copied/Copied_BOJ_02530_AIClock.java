package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_02530_AIClock {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(br.readLine());

		m += time / 60;
		s += time % 60;
		
		m += s / 60;
		s = s % 60;
		
		h += m / 60;
		m = m % 60;
		
		h = h % 24;
		
		System.out.println(h + " " + m + " " + s);

	}

}

// reference: https://comain.tistory.com/11