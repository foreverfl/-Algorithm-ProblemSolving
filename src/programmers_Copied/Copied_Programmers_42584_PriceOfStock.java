package programmers_Copied;

import java.util.Arrays;

public class Copied_Programmers_42584_PriceOfStock {

	public static void main(String[] args) {
		int[] arr = solution(new int[] { 1, 2, 3, 2, 3 });
		System.out.println(Arrays.toString(arr));
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				answer[i]++;
				if (prices[i] > prices[j])
					break;
			}
		}
		return answer;
	}

}
