package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_01254_MakingPalindrome {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		System.out.println(calculate(str));

	}

	private static int calculate(String input) {

		for (int i = 0; i < input.length(); i++) {
			if (isPalindrome(input.substring(i))) {
				return input.length() + i; // If the substring is palindrome, add the part which is not palindrome.
			}
		}

		return input.length() * 2;  // If the substring doesn't contain palindrome.
	}

	private static boolean isPalindrome(String input) {

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

}

// reference: https://hidelookit.tistory.com/182
