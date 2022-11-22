package programmers;

public class Programmers_72410_RecommendingNewID {
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println(solution("z-+.^."));
		System.out.println(solution("=.="));
		System.out.println(solution("123_.def"));
		System.out.println(solution("abcdefghijklmn.p"));
	}

	public static String solution(String new_id) {

		// 1
		new_id = new_id.toLowerCase();

		// 2
		String tmp = "";
		for (int i = 0; i < new_id.length(); i++) {
			if ((new_id.charAt(i) >= 'a' && new_id.charAt(i) <= 'z')
					|| (new_id.charAt(i) >= '0' && new_id.charAt(i) <= '9') || new_id.charAt(i) == '-'
					|| new_id.charAt(i) == '_' || new_id.charAt(i) == '.') {
				tmp += new_id.charAt(i);
			}
		}
		new_id = tmp;

		// 3
		new_id = new_id.replaceAll("\\.{2,}", ".");

		// 4
		tmp = "";
		if (new_id.charAt(0) != '.') {
			tmp += new_id.charAt(0);
		}

		for (int i = 1; i < new_id.length() - 1; i++) {
			tmp += new_id.charAt(i);
		}

		if (new_id.charAt(new_id.length() - 1) != '.') {
			tmp += new_id.charAt(new_id.length() - 1);
		}

		new_id = tmp;

		// 5
		if (new_id.equals("")) {
			new_id = "a";
		}

		// 6
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
		}

		// 4 반복(점 제거)
		tmp = "";
		if (new_id.charAt(0) != '.') {
			tmp += new_id.charAt(0);
		}

		for (int i = 1; i < new_id.length() - 1; i++) {
			tmp += new_id.charAt(i);
		}

		if (new_id.charAt(new_id.length() - 1) != '.') {
			tmp += new_id.charAt(new_id.length() - 1);
		}

		new_id = tmp;

		// 7
		if (new_id.length() <= 2) {
			while (true) {
				new_id += new_id.charAt(new_id.length() - 1);

				if (new_id.length() == 3)
					break;
			}
		}

		return new_id;
	}
}
