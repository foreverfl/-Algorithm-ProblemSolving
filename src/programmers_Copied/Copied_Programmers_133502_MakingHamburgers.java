package programmers_Copied;

import java.util.Stack;

public class Copied_Programmers_133502_MakingHamburgers {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 1, 1, 2, 3, 1 }));
	}

	public static int solution(int[] ingredient) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < ingredient.length; i++) {
			stack.push(ingredient[i]);
			if (stack.size() > 3 && stack.peek() == 1 && stack.get(stack.size() - 2) == 3
					&& stack.get(stack.size() - 3) == 2 && stack.get(stack.size() - 4) == 1) {
				for (int j = 0; j < 4; j++) {
					stack.pop();
				}
				answer++;
			}

		}

		return answer;
	}

}
