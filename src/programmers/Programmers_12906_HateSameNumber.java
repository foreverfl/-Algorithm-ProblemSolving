package programmers;

import java.util.Stack;

public class Programmers_12906_HateSameNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (stack.isEmpty()) {
				stack.push(arr[i]);
			} else {
				if (stack.peek() != arr[i]) {
					stack.push(arr[i]);
				}
			}
		}

		int[] answer = new int[stack.size()];
		for (int i = answer.length - 1; i >= 0; i--) {
			answer[i] = stack.pop();
		}

		return answer;
	}

}
