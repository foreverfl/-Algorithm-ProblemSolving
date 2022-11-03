package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_03009_04stDot {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] x = new int[3];
		int[] y = new int[3];
		int a = 0;
		int b = 0;

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(x);
		Arrays.sort(y);
		
		// coordinate 'x'
		int[] check_1 = new int[2];
		int[] check_2 = new int[2];
	
		check_1[0] = x[0]; // ù �� �ֱ�

		if (x[0] == x[1]) {
			check_1[1] = x[1];
			check_2[0] = x[2];
		} else {
			check_2[0] = check_2[1] = x[1];
		}

		if (check_1[1] == 0) {
			a = check_1[0];
		} else {
			a = check_2[0];
		}

		// coordinate 'y'
		check_1 = new int[2];
		check_2 = new int[2];
		
		check_1[0] = y[0]; // ù �� �ֱ�

		if (y[0] == y[1]) {
			check_1[1] = y[1];
			check_2[0] = y[2];
		} else {
			check_2[0] = check_2[1] = y[1];
		}

		if (check_1[1] == 0) {
			b = check_1[0];
		} else {
			b = check_2[0];
		}

		System.out.println(a + " " + b);
	}

}
