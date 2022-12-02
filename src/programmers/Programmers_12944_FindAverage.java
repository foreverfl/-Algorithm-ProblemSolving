package programmers;

public class Programmers_12944_FindAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double solution(int[] arr) {
		double answer = 0;
		for (int num : arr) {
			answer += num;
		}

		answer /= arr.length;

		return answer;
	}

}
