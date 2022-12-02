package programmers;

public class Programmers_120830_LambSkewers {

	public static void main(String[] args) {
		System.out.println(solution(10, 3));
		System.out.println(solution(64, 6));
	}

	public static int solution(int n, int k) {
		int service = n / 10;
		k = k - service;
		int ans = n * 12000 + k * 2000;
		return ans;
	}

}
