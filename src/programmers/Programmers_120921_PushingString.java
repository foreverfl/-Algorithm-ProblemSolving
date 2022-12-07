package programmers;

public class Programmers_120921_PushingString {

	public static void main(String[] args) {
		System.out.println(solution("hello", "ohell"));
		System.out.println(solution("apple", "elppa"));
	}

	public static int solution(String A, String B) {

		StringBuilder sb = new StringBuilder(A);
		char tmp = ' ';

		if (isSame(A, B)) {
			return 0;
		}

		int answer = 0;
		for (int i = 1; i < A.length(); i++) {
			answer++;
			tmp = sb.charAt(A.length() - 1);
			sb.insert(0, tmp);
			sb.delete(A.length(), A.length() + 1);
			if (isSame(sb.toString(), B)) {
				return answer;
			}
		}

		return -1;
	}

	private static boolean isSame(String A, String B) {

		if (A.equals(B))
			return true;

		return false;

	}

}
