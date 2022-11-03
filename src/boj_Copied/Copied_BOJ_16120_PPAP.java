package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Copied_BOJ_16120_PPAP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);

			if (temp == 'P')
				stack.push('P');

			else {
				if (stack.size() >= 2 && i < str.length() - 1 && str.charAt(i + 1) == 'P') {
					stack.pop();
					stack.pop();
				} else {
					System.out.println("NP");
					return;
				}
			}
		}
		if (stack.size() == 1)
			System.out.println("PPAP");
		else
			System.out.println("NP");
	}

}

// reference: https://velog.io/@pss407/%EB%B0%B1%EC%A4%8016120-PPAP