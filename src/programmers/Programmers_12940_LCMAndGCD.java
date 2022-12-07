package programmers;

public class Programmers_12940_LCMAndGCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] solution(int n, int m) {
		int[] answer = new int[2];
		answer[0] = calcGCD(n, m);
		answer[1] = calcLCM(n, m);
		return answer;
	}

	// 최대공약수(Greatest Common Denominator)
	private static int calcGCD(int a, int b) {
		// 무조건 a가 큰 수여야 된다.
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		if (a % b == 0) {
			return b;
		}
		return calcGCD(b, a % b);
	}

	// 최소공배수(Lowest Common Multiple)
	private static int calcLCM(int a, int b) {
		return a * b / calcGCD(a, b);
	}
}
