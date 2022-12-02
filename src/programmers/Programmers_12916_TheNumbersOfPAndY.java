package programmers;

public class Programmers_12916_TheNumbersOfPAndY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean solution(String s) {
		s = s.toLowerCase();
		int p = 0;
		int y = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'p') {
				p++;
			} else if (s.charAt(i) == 'y') {
				y++;
			}
		}

		if (p == y)
			return true;
		else
			return false;
	}

}
