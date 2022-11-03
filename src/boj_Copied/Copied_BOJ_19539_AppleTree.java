package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_19539_AppleTree {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int tmp;
		int sum = 0;
		int num = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			sum += tmp;
			if (tmp % 2 == 1) { 
				num++; // the number of odd numbers
			}
		}
		
		if (sum % 3 == 0 && num <= sum / 3)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}

// reference: https://moons-memo.tistory.com/36