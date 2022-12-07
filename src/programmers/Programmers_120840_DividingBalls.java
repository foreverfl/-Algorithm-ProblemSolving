package programmers;

import java.math.BigInteger;

public class Programmers_120840_DividingBalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int solution(int balls, int share) {
		BigInteger ans = getFactorial(balls).divide((getFactorial(balls - share).multiply(getFactorial(share))));
		return ans.intValue();
	}

	private static BigInteger getFactorial(int num) {
		BigInteger res = BigInteger.ONE;

		for (int i = 1; i <= num; i++) {
			BigInteger now = new BigInteger(String.valueOf(i));
			res = res.multiply(now);
		}

		return res;
	}

}
