package programmers;

public class Programmers_120818_GettingDiscount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int price) {
		double ans = price;

		if (price >= 500000) {
			ans = ans * 0.8;
		} else if (price >= 300000) {
			ans = ans * 0.9;
		} else if (price >= 100000) {
			ans = ans * 0.95;
		}
		return (int) ans;
	}

}
