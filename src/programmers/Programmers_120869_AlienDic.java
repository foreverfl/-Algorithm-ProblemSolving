package programmers;

public class Programmers_120869_AlienDic {

	public static void main(String[] args) {
		System.out.println(
				solution(new String[] { "p", "o", "s" }, new String[] { "sod", "eocd", "qixm", "adio", "soo" }));
		System.out.println(solution(new String[] { "z", "d", "x" }, new String[] { "def", "dww", "dzx", "loveaw" }));
		System.out.println(
				solution(new String[] { "s", "o", "m", "d" }, new String[] { "moos", "dzx", "smm", "sunmmo", "som" }));
	}

	public static int solution(String[] spell, String[] dic) {
		int[] check = new int[26];
		for (int i = 0; i < spell.length; i++) {
			check[spell[i].charAt(0) - 'a']++;
		}

		for (int i = 0; i < dic.length; i++) {
			int[] tmp = new int[26];
			for (int j = 0; j < dic[i].length(); j++) {
				char now = dic[i].charAt(j);
				tmp[now - 'a']++;
			}
			if (isSame(check, tmp))
				return 1;

		}

		return 2;
	}

	private static boolean isSame(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}

}
