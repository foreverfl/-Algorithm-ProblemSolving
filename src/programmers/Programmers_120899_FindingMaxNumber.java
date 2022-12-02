package programmers;

public class Programmers_120899_FindingMaxNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int[] array) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			max = Math.max(max, array[i]);
		}

		int[] answer = new int[2];
		for (int i = 0; i < array.length; i++) {
			if (max == array[i]) {
				answer[0] = max;
				answer[1] = i;
				break;
			}
		}
		return answer;
	}
}
