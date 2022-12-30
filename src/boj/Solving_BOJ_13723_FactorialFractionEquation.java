package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solving_BOJ_13723_FactorialFractionEquation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		BigInteger factorial = calcFactorial(N);
		int possible = 0;

		for (int i = factorial.intValue() + 1; i < factorial.intValue() * 2; i++) {
			if(i == factorial.intValue()+1) {
				possible++;
				continue;				
			}
			
			BigInteger now = new BigInteger(String.valueOf(i));
			if (now.gcd(factorial).compareTo(BigInteger.ONE) != 0) {
				possible++;
			}
		}

		System.out.println(possible * 2 + 1);
	}

	private static BigInteger calcFactorial(int num) {
		BigInteger res = BigInteger.ONE;

		for (int i = 1; i <= num; i++) {
			BigInteger tmp = new BigInteger(String.valueOf(i));
			res = res.multiply(tmp);
		}

		return res;
	}

}
