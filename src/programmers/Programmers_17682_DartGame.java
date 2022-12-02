package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Programmers_17682_DartGame {

	public static void main(String[] args) {
		System.out.println(solution("0*10*10*"));
		
		System.out.println(solution("1S2D*3T"));
		System.out.println(solution("1D2S#10S"));
		System.out.println(solution("1D2S0T"));
		System.out.println(solution("1S*2T*3S"));
		System.out.println(solution("1D#2S*3S"));
		System.out.println(solution("1T2D3D#"));
		System.out.println(solution("1D2S3T*"));
	}

	private static final int SCORE_10 = 0;
	private static final int SCORE = 1;
	private static final int BONUS = 2;
	private static final int OPTION = 3;
	private static Deque<Integer> deque = new ArrayDeque<>(2);

	public static int solution(String dartResult) {
		for (int i = 0; i < 2; i++) {
			deque.add(0);
		}
		int answer = 0;

		for (int i = 0; i < dartResult.length(); i++) {
			char now = dartResult.charAt(i);
			char nxt = ' ';
			if (i != dartResult.length() - 1) {
				nxt = dartResult.charAt(i + 1);
			}
			int tmp = 0;

			int condition = decide(now, nxt);
			if (condition == SCORE_10) {
				answer += calcScore(10);
				i++;
				continue;
			} else if (condition == SCORE) {
				answer += calcScore(now - '0');
			} else if (condition == BONUS) {
				tmp = deque.pollFirst();
				if (now == 'S') {
					tmp = (int) Math.pow(tmp, 1);
				} else if (now == 'D') {
					tmp = (int) Math.pow(tmp, 2);
				} else if (now == 'T') {
					tmp = (int) Math.pow(tmp, 3);
				}
				deque.offerFirst(tmp);

			} else if (condition == OPTION) {
				if (now == '*') {
					tmp = deque.pollFirst();
					tmp *= 2;
					deque.offerFirst(tmp);
					tmp = deque.pollLast();
					tmp *= 2;
					deque.offerLast(tmp);
				} else {
					tmp = deque.pollFirst();
					tmp *= -1;
					deque.offerFirst(tmp);
				}
			}

		}
		
		// 남은 점수 합산
		while (!deque.isEmpty()) {
			answer += deque.poll();
		}
		return answer;
	}

	private static int decide(char now, char nxt) {
		if (now == '1' && nxt == '0') {
			return SCORE_10;
		} else if (now >= '0' && now <= '9') {
			return SCORE;
		} else if (now >= 'A' && now <= 'Z') {
			return BONUS;
		} else {
			return OPTION;
		}
	}

	private static int calcScore(int score) {
		int tmp = 0;
		int res = 0;

		// 두 번째 값을 점수에 합산하기 위해 따로 저장한다.
		res = deque.pollLast();

		// 첫번째 값을 두번째로 옮긴다.
		tmp = deque.pollFirst();
		deque.offerLast(tmp);

		// 데크에 새로운 값을 넣는다.
		deque.offerFirst(score);

		return res;
	}
}
