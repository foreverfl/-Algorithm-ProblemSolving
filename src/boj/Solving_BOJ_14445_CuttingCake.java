package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solving_BOJ_14445_CuttingCake {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger N = new BigInteger(br.readLine());

		double tmp = N.sqrt().doubleValue();
		long ans = ((long) tmp) * 2;

		System.out.println(ans);
	}

}
