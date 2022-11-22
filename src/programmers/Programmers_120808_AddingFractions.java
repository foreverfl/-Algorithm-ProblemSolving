package programmers;

public class Programmers_120808_AddingFractions {

	public static void main(String[] args) {
		System.out.println(solution(1, 2, 3, 4)[0] + " " + solution(1, 2, 3, 4)[1]);
		System.out.println(solution(9, 2, 1, 3)[0] + " " + solution(9, 2, 1, 3)[1]);

	}

	public static int[] solution(int denum1, int num1, int denum2, int num2) {
		int[] answer = new int[2];
		int LCM = calcLCM(num1, num2);
		int div1 = LCM / num1;
		int div2 = LCM / num2;
		int deno1 = denum1 * div1;
		int deno2 = denum2 * div2;
		answer[0] = deno1 + deno2;
		answer[1] = LCM;
		
		int LCM2 = calcGCD(answer[0], answer[1]);
		answer[0] /= LCM2; 
		answer[1] /= LCM2;
		
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
