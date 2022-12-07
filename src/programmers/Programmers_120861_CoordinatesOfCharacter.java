package programmers;

public class Programmers_120861_CoordinatesOfCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] solution(String[] keyinput, int[] board) {
		int max_x = board[0] / 2;
		int max_y = board[1] / 2;

		int[] answer = new int[2];

		for (int i = 0; i < keyinput.length; i++) {
			if (keyinput[i].equals("left")) {
				answer[0]--;

				if (!isPossible(max_x, max_y, answer[0], answer[1]))
					answer[0]++;
			} else if (keyinput[i].equals("right")) {
				answer[0]++;

				if (!isPossible(max_x, max_y, answer[0], answer[1]))
					answer[0]--;
			} else if (keyinput[i].equals("down")) {
				answer[1]--;

				if (!isPossible(max_x, max_y, answer[0], answer[1]))
					answer[1]++;
			} else if (keyinput[i].equals("up")) {

				answer[1]++;

				if (!isPossible(max_x, max_y, answer[0], answer[1]))
					answer[1]--;
			}
		}

		return answer;
	}

	private static boolean isPossible(int max_x, int max_y, int x, int y) {
		if (Math.abs(x) <= Math.abs(max_x) && Math.abs(y) <= Math.abs(max_y))
			return true;

		return false;
	}
}
