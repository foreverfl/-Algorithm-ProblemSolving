package programmers;

public class Programmers_120924_TheNextNumber {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 4 }));
		System.out.println(solution(new int[] { 2, 4, 8 }));

	}

	public static int solution(int[] common) {
		int ans = 0;
		if (isArithmetical(common)) {
			int tmp = common[1] - common[0];
			ans = common[common.length - 1] + tmp;
		}

		if (isGeometric(common)) {
			int tmp = common[1] / common[0];
			ans = common[common.length - 1] * tmp;

		}

		return ans;
	}

	private static boolean isArithmetical(int[] arr) {
		int a = arr[1] - arr[0];
		int b = arr[2] - arr[1];

		if (a == b)
			return true;
		else
			return false;

	}

	private static boolean isGeometric(int[] arr) {
		double a = (double) arr[1] / arr[0];
		double b = (double) arr[2] / arr[1];

		if (a == b)
			return true;
		else
			return false;
	}

}
