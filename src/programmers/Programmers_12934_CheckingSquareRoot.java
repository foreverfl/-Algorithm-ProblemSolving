package programmers;

public class Programmers_12934_CheckingSquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long solution(long n) {
		double sqrt = Math.sqrt((double) n);
		int tmp = (int) sqrt;
		if (sqrt - tmp == 0) {
			return (long) Math.pow(sqrt + 1, 2);
		} else {
			return -1;
		}
	}

}
