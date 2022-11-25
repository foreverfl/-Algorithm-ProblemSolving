package programmers;

public class Programmers_131128_NumberPair {

	public static void main(String[] args) {
		System.out.println(solution("5525", "1255"));
		System.out.println(solution("100", "2345"));
		System.out.println(solution("100", "203045"));
		System.out.println(solution("100", "123450"));
		System.out.println(solution("12321", "42531"));

	}

	public static String solution(String X, String Y) {
		int[] X_check = new int[10];
		int[] Y_check = new int[10];
		int[] toUse = new int[10];

		for (int i = 0; i < X.length(); i++) {
			X_check[X.charAt(i) - '0']++;
		}

		for (int i = 0; i < Y.length(); i++) {
			Y_check[Y.charAt(i) - '0']++;
		}

		for (int i = 0; i < 10; i++) {
			if (X_check[i] > 0 && Y_check[i] > 0) {
				int cnt = Math.min(X_check[i], Y_check[i]);
				toUse[i] += cnt;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 9; i >= 0; i--) {
			while (true) {
				if (toUse[i] == 0)
					break;

				sb.append(i);
				toUse[i]--;

			}
		}

		if (sb.toString().equals("")) {
			return "-1";
		} else if (sb.toString().startsWith("0")) {
			return "0";
		} else {
			return sb.toString();
		}

	}

}
