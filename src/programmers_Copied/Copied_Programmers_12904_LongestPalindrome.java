package programmers_Copied;

public class Copied_Programmers_12904_LongestPalindrome {

	public static void main(String[] args) {
		System.out.println(solution("abcdcba"));
		System.out.println(solution("abacde"));

	}

	public static int solution(String s) {
		char[] chr = s.toCharArray();

		for (int leng = s.length(); leng > 1; leng--) {

			for (int start = 0; start + leng <= s.length(); start++) {
				boolean chk = true;

				for (int i = 0; i < leng / 2; i++) {
					if (chr[start + i] != chr[start + leng - i - 1]) {
						chk = false;
						break;
					}
				}

				if (chk)
					return leng;
			}
		}

		return 1;
	}

}
