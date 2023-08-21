package algorithm;

public class GCDAndLCM {
	// 최대공약수(Greatest Common Denominator)
	public static int calcGCD1(int a, int b) {
		// 무조건 a가 큰 수여야 된다.
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		if (a % b == 0) {
			return b;
		}
		return calcGCD1(b, a % b);
	}

	// 최소공배수(Lowest Common Multiple)
	public static int calcLCM(int a, int b) {
		return a * b / calcGCD1(a, b);
	}

	// 최대공약수(재귀)
	public static int calcGCD2(int a, int b) {
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		return (b == 0) ? a : calcGCD2(b, a % b);
	}

}
