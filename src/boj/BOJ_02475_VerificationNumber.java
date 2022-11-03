package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02475_VerificationNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int sum = (int) Math.pow(A, 2) + (int) Math.pow(B, 2) + (int) Math.pow(C, 2) + (int) Math.pow(D, 2)
				+ (int) Math.pow(E, 2);

		int result = sum % 10;

		System.out.println(result);
	}

}
