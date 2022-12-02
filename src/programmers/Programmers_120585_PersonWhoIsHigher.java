package programmers;


public class Programmers_120585_PersonWhoIsHigher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] array, int height) {
		int ans = 0;
		for (int num : array) {
			if (num > height)
				ans++;
		}

		return ans;
	}

}
