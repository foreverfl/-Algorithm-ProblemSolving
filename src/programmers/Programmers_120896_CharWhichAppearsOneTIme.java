package programmers;

public class Programmers_120896_CharWhichAppearsOneTIme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(String s) {
		int[] visited = new int[26];

		for (int i = 0; i < s.length(); i++) {
			visited[s.charAt(i) - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (visited[i] == 1) {
				sb.append((char) (i + 'a'));
			}
		}

		return sb.toString();
	}

}
