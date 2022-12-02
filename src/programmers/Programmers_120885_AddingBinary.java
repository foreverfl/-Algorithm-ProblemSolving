package programmers;

import java.math.BigInteger;

public class Programmers_120885_AddingBinary {

	public static void main(String[] args) {
		System.out.println(solution("10", "11"));
		System.out.println(solution("1001", "1111"));
	}

	public static String solution(String bin1, String bin2) {
		BigInteger A_binary = new BigInteger(bin1, 2);
		BigInteger B_binary = new BigInteger(bin2, 2);

		BigInteger sum = A_binary.add(B_binary);

		// 풀이방식에 적어둔 대로 2진수로 변환
		String ans = sum.toString(2);
		return ans;
	}

}
