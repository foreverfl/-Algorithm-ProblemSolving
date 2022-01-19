package BOJ_Copied;

import java.util.Scanner;
import java.util.Stack;

public class Copied_BOJ_17413_ReversingWords_2 {
	static void print(Stack<Character> st) {
		while (!st.empty()) {
			System.out.print(st.peek());
			st.pop();
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<Character>();

		String input = sc.nextLine();
		boolean check = false;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '<') {
				print(stack); // After encountering '<', print reversely
				check = true; // '<' → open
				System.out.print(input.charAt(i));
			} else if (input.charAt(i) == '>') {
				check = false; // '>' → close
				System.out.print(input.charAt(i));
			} else if (check) {
				System.out.print(input.charAt(i));
			} else {
				if (input.charAt(i) == ' ') { // After encountering ' ', print reversely
					print(stack);
					System.out.print(input.charAt(i));
				}

				else {
					stack.push(input.charAt(i));
				}
			}

		}

		print(stack); // processing the remains

	}

}

// reference: https://1-7171771.tistory.com/27