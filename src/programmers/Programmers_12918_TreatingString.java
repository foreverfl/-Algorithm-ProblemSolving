package programmers;

public class Programmers_12918_TreatingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean solution(String s) {
		if ((s.length() == 4 || s.length() == 6) && isDigit(s))
			return true;

		return false;
	}

	private static boolean isDigit(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}
		return true;
	}
}
