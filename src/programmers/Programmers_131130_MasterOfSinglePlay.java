package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers_131130_MasterOfSinglePlay {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 8, 6, 3, 7, 2, 5, 1, 4 }));
	}

	public static int solution(int[] cards) {
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= cards.length; i++) {

			int now = i;
			int cnt = 0;
			while (true) {
				if (cards[now - 1] == 0)
					break;

				int tmp = now;

				now = cards[tmp - 1];
				cards[tmp - 1] = 0;
				cnt++;
			}
			
			if (cnt != 0)
				list.add(cnt);

		}

		Collections.sort(list, Collections.reverseOrder());

		int answer = 0;

		if (list.size() >= 2) {
			answer = list.get(0) * list.get(1);
		}

		return answer;
	}

}
