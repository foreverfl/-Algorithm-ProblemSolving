package programmers;

public class Programmers_120863_AddingThePolynomial {

	public static void main(String[] args) {
		System.out.println(solution("3x + 7 + x"));

	}

	public static String solution(String polynomial) {
		String[] arr = polynomial.split("[+]");

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].trim();
		}

		int a = 0; // 변수
		int b = 0; // 상수
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].charAt(arr[i].length() - 1) == 'x') {
				String tmp = "";
				for (int j = 0; j < arr[i].length() - 1; j++) {
					tmp += arr[i].charAt(j);
				}

				int now = 0;
				if (tmp.equals("")) {
					now = 1;
				} else {
					now = Integer.parseInt(tmp);
				}
				a += now;

			} else {
				int now = Integer.parseInt(arr[i]);
				b += now;
			}

		}

		// 변수
		String str1 = "";
		if (a == 0) {

		} else if (a == 1) {
			str1 = "x";
		} else {
			str1 = a + "x";
		}

		// 상수
		String str2 = "";
		if (b == 0) {

		} else if (b == 1) {
			str2 = "1";
		} else {
			str2 = b + "";
		}

		String answer = "";
		if (str1.equals("")) {
			answer = str2;
		} else if (str2.equals("")) {
			answer = str1;
		} else {
			answer = str1 + " + " + str2;
	
		}

		
		return answer;
	}
}
