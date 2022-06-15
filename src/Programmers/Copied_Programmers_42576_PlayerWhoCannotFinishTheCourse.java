package Programmers;

import java.util.HashMap;

public class Copied_Programmers_42576_PlayerWhoCannotFinishTheCourse {

	public static void main(String[] args) {
		String[] participant_1 = { "leo", "kiki", "eden" };
		String[] completion_1 = { "eden", "kiki" };
		String res_1 = solution(participant_1, completion_1);
		System.out.println(res_1);

		String[] participant_2 = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion_2 = { "josipa", "filipa", "marina", "nikola" };
		String res_2 = solution(participant_2, completion_2);
		System.out.println(res_2);

		String[] participant_3 = { "mislav", "stanko", "mislav", "ana" };
		String[] completion_3 = { "stanko", "ana", "mislav" };
		String res_3 = solution(participant_3, completion_3);
		System.out.println(res_3);

	}

	public static String solution(String[] participant, String[] completion) {

		String ans = "";
		HashMap<String, Integer> hashmap = new HashMap<>();
		for (String player : participant)
			hashmap.put(player, hashmap.getOrDefault(player, 0) + 1);
		
		for (String player : completion)
			hashmap.put(player, hashmap.get(player) - 1);

		for (String key : hashmap.keySet()) {
			if (hashmap.get(key) != 0) {
				ans = key;
			}
		}
		return ans;
	}

}

// reference: https://velog.io/@qweadzs/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%99%84%EC%A3%BC%ED%95%98%EC%A7%80-%EB%AA%BB%ED%95%9C-%EC%84%A0%EC%88%98
