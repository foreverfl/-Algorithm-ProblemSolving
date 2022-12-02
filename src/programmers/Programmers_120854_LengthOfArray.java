package programmers;

public class Programmers_120854_LengthOfArray {
	public static void main(String[] args) {

	}

	public int[] solution(String[] strlist) {
		int[] answer = new int[strlist.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = strlist[i].length();
		}
		return answer;
	}
}
