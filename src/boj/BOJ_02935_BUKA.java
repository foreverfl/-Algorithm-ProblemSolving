package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_02935_BUKA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String operator = br.readLine();
		String B = br.readLine();
		
		BigInteger bigintegerA = new BigInteger(A);
		BigInteger bigintegerB = new BigInteger(B);
		BigInteger result = BigInteger.ZERO;


		if (operator.equals("+"))
			result = bigintegerA.add(bigintegerB);
		else
			result = bigintegerA.multiply(bigintegerB);

		System.out.println(result);

	}

}
