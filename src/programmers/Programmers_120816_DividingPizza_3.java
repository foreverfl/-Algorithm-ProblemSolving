package programmers;

public class Programmers_120816_DividingPizza_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int slice, int n) {
		int answer = 0;
		int slice_now = 0;
		while (true) {
			if (slice_now >= n)
				break;

			answer++;
			slice_now += slice;

		}

		return answer;
	}

}
