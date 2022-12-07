package programmers;

public class Programmers_12935_RemovingTheLeastNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int[] arr) {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++)
			min = Math.min(min, arr[i]);

		int[] answer;
		if (arr.length == 1) {
			answer = new int[] { -1 };
		} else {
			answer = new int[arr.length - 1];
			int idx = 0;
			for (int num : arr) {
				if (num == min)
					continue;
				answer[idx++] = num;
			}
		}

		return answer;
	}

}
