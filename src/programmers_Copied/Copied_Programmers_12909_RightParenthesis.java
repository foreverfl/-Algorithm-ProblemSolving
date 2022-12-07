package programmers_Copied;

import java.util.Stack;

public class Copied_Programmers_12909_RightParenthesis {

	public static void main(String[] args) {
		System.out.println(solution("()()"));
		System.out.println(solution("(())()"));
		System.out.println(solution(")()("));
		System.out.println(solution("(()("));

	}

	static boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			} else {
				stack.push('(');
			}
		}
		
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

}
