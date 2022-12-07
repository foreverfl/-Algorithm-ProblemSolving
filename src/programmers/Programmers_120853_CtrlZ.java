package programmers;

public class Programmers_120853_CtrlZ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(String s) {

		int answer = 0;
		int tmp = 0;
		String[] arr = s.split(" ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("Z")) {
				answer -= tmp;
			} else {
				answer += Integer.parseInt(arr[i]);
				tmp = Integer.parseInt(arr[i]);
			}
		}

		return answer;
	}

}
