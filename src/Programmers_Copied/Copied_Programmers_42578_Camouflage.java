package Programmers_Copied;

import java.util.HashMap;

public class Copied_Programmers_42578_Camouflage {
	public static void main(String[] args) {
		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		int result = solution(clothes);
		System.out.println(result);
	}

	// (A+1)*(B+1) - 1
	
	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> hashmap = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			hashmap.put(clothes[i][1], hashmap.getOrDefault(clothes[i][1], 0) + 1);
		}
		for (String key : hashmap.keySet()) {
			answer *= (hashmap.get(key) + 1);
		}
		answer -= 1;
		return answer;
	}

}


// reference: https://junghn.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9C%84%EC%9E%A5-%ED%95%B4%EC%8B%9C-1