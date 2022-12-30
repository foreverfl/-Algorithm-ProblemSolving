package programmers;

public class Programmers_142086_NearestChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(String s) {
		int[] answer = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int now = -1;
			int dist = 0;
			for (int j = i - 1; j >= 0; j--) {
				dist++;
				if (s.charAt(i) == s.charAt(j)) {
					now = dist;
					break;
				}
			}

			answer[i] = now;
		}

		return answer;
	}

}
