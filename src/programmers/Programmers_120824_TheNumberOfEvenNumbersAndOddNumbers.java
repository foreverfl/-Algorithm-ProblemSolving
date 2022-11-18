package programmers;

public class Programmers_120824_TheNumberOfEvenNumbersAndOddNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int[] num_list) {
		int[] ans = new int[2];
		int cntOdd = 0;
		int cntEven = 0;

		for (int i = 0; i < num_list.length; i++) {
			if (num_list[i] % 2 == 0)
				cntEven++;
			else
				cntOdd++;

		}

		ans[0] = cntEven;
		ans[1] = cntOdd;

		return ans;
	}

}
