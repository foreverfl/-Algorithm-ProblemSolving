package programmers;

import java.util.Arrays;
import java.util.Stack;

public class Copied_Programmers_42584_PriceOfStock {

	public static void main(String[] args) {
		int[] arr = solution(new int[] { 1, 2, 3, 2, 3 });
		System.out.println(Arrays.toString(arr));
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty()) {
				if (prices[stack.peek()] > prices[i]) {
					Integer idx = stack.pop();
					answer[idx] = i - idx;
					continue;
				}
				break;
			}
			stack.add(i);
		}
		while (!stack.isEmpty()) {
			Integer idx = stack.pop();
			answer[idx] = prices.length - 1 - idx;
		}
		return answer;
	}

}
