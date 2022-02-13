package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10988_CheckingWhetherToPalindrome {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		StringBuffer sb = new StringBuffer(input);

		String reverse_input = sb.reverse().toString();

		if (input.equals(reverse_input)) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}

	}

}
