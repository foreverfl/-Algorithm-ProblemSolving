package programmers;

public class Programmers_FindingTheNumberWhoseDivisorIsOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int n) {
		int divisor = 1;
		while (true) {
			if (n % divisor == 1) {
				break;
			}

			divisor++;
		}
		return divisor;
	}

}
