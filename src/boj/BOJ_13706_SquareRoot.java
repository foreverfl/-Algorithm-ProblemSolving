package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_13706_SquareRoot {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		sqrt(num);
	}

	static void sqrt(String num) {

		BigInteger one = BigInteger.ONE;
		BigInteger two = new BigInteger("2");

		BigInteger target = new BigInteger(num);

		BigInteger left = BigInteger.ONE;
		BigInteger right = new BigInteger(num);

		BigInteger mid, x;

		while (left.compareTo(right) <= 0) {

			mid = (left.add(right)).divide(two);
			x = mid.multiply(mid);

			int ret = x.compareTo(target);
			
			if (ret == 0) {
				System.out.println(mid.toString());
				break;

			} else if (ret == -1) {
				left = mid.add(one); // x(mid*mid) is smaller than the 'num' �� left = mid + 1

			} else if (ret == 1) {
				right = mid.subtract(one); // x(mid*mid) is larger than the 'num' �� right = mid-1

			}
		}
	}
}
