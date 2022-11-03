package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11816_Octal_Decimal_Hexadecimal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String X = br.readLine();

		int result = 0;
		if (X.charAt(0) == '0' && X.charAt(1) == 'x') {
			X = X.substring(2);
			result = Integer.parseInt(X, 16);
		} else if (X.charAt(0) == '0') {
			X = X.substring(1);
			result = Integer.parseInt(X, 8);
		} else {
			result = Integer.parseInt(X);
		}

		System.out.println(result);
	}

}
