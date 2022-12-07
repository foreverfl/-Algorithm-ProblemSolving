package programmers;

public class Programmers_76501_AddingPlusAndMinus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] absolutes, boolean[] signs) {
		int size = absolutes.length;
		int answer = 0;
		for (int i = 0; i < size; i++) {
			if (signs[i])
				answer += absolutes[i];
			else
				answer -= absolutes[i];

		}

		return answer;
	}

}
