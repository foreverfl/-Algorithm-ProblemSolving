package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class Copied_BOJ_04949_TheBalanceOfTheWorld {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input;

		while (true) {
			input = sc.nextLine();

			if (input.equals(".")) { // exit
				break;
			}
			System.out.println(solve(input));
		}

	}

	private static String solve(String input) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < input.length(); i++) {

			char c = input.charAt(i);
			
			if (c == '(' || c == '[') {
				stack.push(c);
			}

			else if (c == ')') {

				if (stack.empty() || stack.peek() != '(') {
					return "no";
				} else {
					stack.pop();
				}
			}

			else if (c == ']') {
				if (stack.empty() || stack.peek() != '[') {
					return "no";
				} else {
					stack.pop();
				}
			}
		}

		if (stack.empty()) {
			return "yes";
		} else {
			return "no";
		}
	}

}

// reference: https://st-lab.tistory.com/180