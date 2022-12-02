package programmers;

public class Programmers_120909_CheckingSquareNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int n) {
		double num = Math.sqrt((double) n);
		int integer = (int) num;
		if (num - integer == 0)
			return 1;
		else
			return 2;
	}

}
