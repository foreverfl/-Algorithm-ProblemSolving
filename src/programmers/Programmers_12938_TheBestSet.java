package programmers;

public class Programmers_12938_TheBestSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int n, int s) {
		if (n > s)
			return new int[] { -1 };

		int[] answer = new int[n];
		for (int i = 0; i < answer.length; i++)
			answer[i] = s / n;

		int repeat = s % n;
		int idx = answer.length - 1;
		while (repeat > 0) {
			answer[idx--]++;
			repeat--;
		}

		return answer;
	}

}
