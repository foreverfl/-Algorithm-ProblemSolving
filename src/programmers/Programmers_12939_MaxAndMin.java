package programmers;

public class Programmers_12939_MaxAndMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(String s) {
		String[] arr = s.split(" ");
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int now = Integer.parseInt(arr[i]);
			max = Math.max(max, now);
			min = Math.min(min, now);
		}

		String answer = min + " " + max;
		return answer;
	}

}
