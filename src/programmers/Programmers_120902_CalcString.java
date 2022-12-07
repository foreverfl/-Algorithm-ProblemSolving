package programmers;

import java.util.StringTokenizer;

public class Programmers_120902_CalcString {

	public static void main(String[] args) {
		System.out.println(solution("3 + 4"));

	}

	public static int solution(String my_string) {
		StringTokenizer st = new StringTokenizer(my_string);

		int answer = 0;
		boolean plus = true;
		while (st.hasMoreTokens()) {
			String now = st.nextToken();

			if (now.equals("+")) {
				plus = true;
			} else if (now.equals("-")) {
				plus = false;
			} else {
				if (plus)
					answer += Integer.parseInt(now);
				else
					answer -= Integer.parseInt(now);
			}

		}
		return answer;
	}

}
