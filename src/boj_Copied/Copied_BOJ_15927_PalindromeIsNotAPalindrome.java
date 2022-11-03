package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_15927_PalindromeIsNotAPalindrome {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int len = str.length();

		boolean flag = false;
		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1)) { // not palindrome
				System.out.println(len);
				return;
			}

			else if (str.charAt(i) != str.charAt(i + 1)) // checking all characters is same
				flag = true;
		}

		if (flag) // palindrome
			System.out.println(len - 1);

		else // All characters is same
			System.out.println(-1);
	}

}

// reference: https://velog.io/@pss407/%EB%B0%B1%EC%A4%8015927-%ED%9A%8C%EB%AC%B8%EC%9D%80-%ED%9A%8C%EB%AC%B8%EC%95%84%EB%8B%88%EC%95%BC