package Programmers_Copied;

import java.util.HashMap;

public class Copied_Programmers_77486_MultilevelToothbrushSell {

	public static void main(String[] args) {
		String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
		String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
		String[] seller = { "young", "john", "tod", "emily", "mary" };
		int[] amount = { 12, 4, 2, 5, 10 };
		int[] result = solution(enroll, referral, seller, amount);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];
		HashMap<String, String> recommendation = new HashMap<>();
		HashMap<String, Integer> memberIndex = new HashMap<>();

		for (int i = 0; i < enroll.length; i++) {
			recommendation.put(enroll[i], referral[i]);
			memberIndex.put(enroll[i], i);
		}

		for (int i = 0; i < seller.length; i++) {

			String getter = seller[i];
			int profit = amount[i] * 100;

			while (true) {
				int toTop = profit / 10;
				int toMe = profit - toTop;

				answer[memberIndex.get(getter)] += toMe;

				getter = recommendation.get(getter);
				profit /= 10;
				
				if (getter.equals("-"))
					break;
				if (profit < 1)
					break;
			}
		}

		return answer;
	}

}

// reference: https://wellbell.tistory.com/159
