package programmers;

public class Programmers_147355_SmallerPartialString {

	public static void main(String[] args) {
		System.out.println(solution("10203", "15"));

	}

	public static int solution(String t, String p) {
		int len = p.length();
		int ans = 0;

		for (int i = 0; i < t.length() - len + 1; i++) {
			String now = "";
			for (int j = i; j < i + len; j++) {
				now += t.charAt(j);
			}
			if (Long.parseLong(now) <= Long.parseLong(p)) {
				ans++;
			}
		}

		return ans;
	}

}
