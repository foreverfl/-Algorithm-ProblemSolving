package programmers;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Programmers_120907_OXQuiz {

	public static void main(String[] args) {
		String[] arr = solution(new String[] { "3 - 4 = -3", "5 + 6 = 11" });
		System.out.println(Arrays.toString(arr));

		arr = solution(new String[] { "19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2" });
		System.out.println(Arrays.toString(arr));
	}

	public static String[] solution(String[] quiz) {
		String[] answer = new String[quiz.length];

		for (int i = 0; i < quiz.length; i++) {
			StringTokenizer st = new StringTokenizer(quiz[i]);
			String a = st.nextToken();
			String sign = st.nextToken();
			String b = st.nextToken();
			st.nextToken();
			String res = st.nextToken();

			int aInt = toInteger(a);
			int bInt = toInteger(b);
			int resInt = toInteger(res);

			if (sign.equals("+")) {
				if (aInt + bInt == resInt)
					answer[i] = "O";
				else
					answer[i] = "X";
			} else {
				if (aInt - bInt == resInt)
					answer[i] = "O";
				else
					answer[i] = "X";
			}
		}

		return answer;
	}

	private static boolean isMinus(String num) {
		if (num.charAt(0) == '-') {
			return true;
		}

		return false;
	}

	private static int toInteger(String str) {
		int ans = 0;
		if (isMinus(str)) {
			String tmp = "";
			for (int i = 1; i < str.length(); i++) {
				tmp += str.charAt(i);
			}
			ans = Integer.parseInt(tmp) * -1;
		} else {
			String tmp = "";
			for (int i = 0; i < str.length(); i++) {
				tmp += str.charAt(i);
			}
			ans = Integer.parseInt(tmp);
		}

		return ans;
	}

}
