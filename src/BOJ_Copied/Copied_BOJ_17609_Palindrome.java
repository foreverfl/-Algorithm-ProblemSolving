package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_17609_Palindrome {

	static int N;
	static String str;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			str = br.readLine();
			arr = str.toCharArray();
			int left = 0;
			int right = str.length() - 1;
			if (palindrome(left, right)) {
				sb.append("0").append('\n');
			} else if (similarPalindrome(left, right)) {
				sb.append("1").append('\n');
			} else {
				sb.append("2").append('\n');
			}
		}
		System.out.println(sb);
	}

	private static boolean palindrome(int left, int right) {
		while (left <= right) {
			if (arr[left] != arr[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	private static boolean similarPalindrome(int left, int right) {
		while (left <= right) {
			if (arr[left] != arr[right]) {
				boolean a = palindrome(left + 1, right);
				boolean b = palindrome(left, right - 1);
				if (a == false && b == false) {
					return false;
				} else
					return true;
			}
			left++;
			right--;
		}
		return true;
	}
}

// https://haerang94.tistory.com/411
