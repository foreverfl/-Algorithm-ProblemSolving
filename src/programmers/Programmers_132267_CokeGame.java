package programmers;

public class Programmers_132267_CokeGame {

	public static void main(String[] args) {

		System.out.println(solution(2, 1, 20));
		System.out.println(solution(3, 1, 20));
	}

	public static int solution(int a, int b, int n) {
		int ans = 0;
		int empty = 0;
		int now = n;
		int give = 0;
		int take = 0;
		while (true) {
			if (now != n)
				ans += now;

			// 지금 있는 콜라를 다 마신다.
			empty += now;
			now = 0;

			// 교환한다.
			give = empty / a;
			if (give == 0)
				break;

			empty = empty % a;
			take = give * b;
			now = take;
		}

		return ans;
	}
}
