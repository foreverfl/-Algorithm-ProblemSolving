package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Programmers_17680_Cache {

	public static void main(String[] args) {
//		System.out.println(solution(3, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo",
//				"Seoul", "NewYork", "LA" }));
//		System.out.println(solution(3,
//				new String[] { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" }));
//		System.out.println(solution(2, new String[] { "Jeju", "Jeju", "Pangyo", "Seoul", "NewYork", "LA",
//				"SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome" }));
//		System.out.println(solution(5, new String[] { "Jeju", "Jeju", "Pangyo", "Seoul", "NewYork", "LA",
//				"SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome" }));
		System.out.println(solution(2, new String[] { "Jeju", "Pangyo", "NewYork", "newyork" }));
		System.out.println(solution(0, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" }));

	}

	public static int solution(int cacheSize, String[] cities) {
		if (cacheSize == 0) {
			return 5 * cities.length;
		}

		Deque<String> deque = new ArrayDeque<>();
		for (int i = 0; i < cities.length; i++) {
			cities[i] = cities[i].toLowerCase();
		}

		int answer = 0;
		for (String city : cities) {
			if (deque.contains(city)) {
				deque.remove(city);
				deque.offerFirst(city);
				answer++;
				continue;
			}

			if (deque.size() < cacheSize) {
				deque.offerFirst(city);
				answer += 5;
			} else {
				deque.removeLast();
				deque.offerFirst(city);
				answer += 5;

			}
		}

		return answer;
	}

}
