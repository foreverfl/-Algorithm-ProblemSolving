package programmers;

public class Programmers_120886_AtoB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(String before, String after) {
		int[] check_before = new int[26];
		int[] check_after = new int[26];
		for (int i = 0; i < before.length(); i++) {
			check_before[before.charAt(i) - 'a']++;
		}

		for (int i = 0; i < after.length(); i++) {
			check_after[after.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (check_before[i] != check_after[i])
				return 0;
		}

		return 1;
	}

}
