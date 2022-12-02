package programmers;

import java.util.HashMap;
import java.util.Map;

public class Programmers_1845_Pocketmon {
	public int solution(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int answer = map.size();
		if (answer > nums.length / 2)
			answer = nums.length / 2;

		return answer;
	}
}
