package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solving_BOJ_18109_Willothewisp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str = br.readLine();

		int ans = 0;
		st = new StringTokenizer(str);
		while (st.hasMoreTokens()) {
			ans += checkPhenomenon(st.nextToken());
		}

		System.out.println(ans);
	}

	// 1 -> first_consonant
	// 2 -> vowel
	// 3 -> last_consonants
	private static int checkPhenomenon(String str) {
		str = str + " ";
		String[] first_consonants = { "r", "R", "s", "e", "E", "f", "a", "q", "Q", "t", "T", "d", "w", "W", "c", "z",
				"x", "v", "g" };

		String[] vowels = { "k", "o", "i", "O", "j", "p", "u", "P", "h", "hk", "ho", "hl", "y", "n", "nj", "np", "nl",
				"b", "m", "ml", "l" };

		String[] last_consonants = { "r", "R", "rt", "s", "sw", "sg", "e", "f", "fr", "fa", "fq", "ft", "fx", "fv",
				"fg", "a", "q", "qt", "t", "T", "d", "w", "c", "z", "x", "v", "g" };

		String check = "";
		String tmp = "";
		for (int i = 0; i < str.length() - 1;) { // checking before last

			// consonant
			tmp = str.charAt(i) + "" + str.charAt(i + 1);
			if (Arrays.asList(first_consonants).contains(tmp) || Arrays.asList(last_consonants).contains(tmp)) {
				check += "1";
				i = i + 2;
				continue;
			}

			tmp = str.charAt(i) + "";
			if (Arrays.asList(first_consonants).contains(tmp) || Arrays.asList(last_consonants).contains(tmp)) {
				check += "1";
				i++;
				continue;

			}

			// vowel
			tmp = str.charAt(i) + "" + str.charAt(i + 1);
			if (Arrays.asList(vowels).contains(tmp)) {
				check += "2";
				i = i + 2;
				continue;
			}

			tmp = str.charAt(i) + "";
			if (Arrays.asList(vowels).contains(tmp)) {
				check += "2";
				i++;
				continue;

			}
		}

		int cnt = 0;
		for (int i = 0; i < check.length() - 1; i++) {
			tmp = check.charAt(i) + "" + check.charAt(i + 1);
			if (tmp.equals("21")) { // answpfmf(문제를)
				cnt++;
			}
		}

		return cnt;
	}

}

/*코딩하기 싫다(2, 0 -> 4)
zheldgkrl tlfgek
씨발(1)
Tlqkf 
서강대학교(2)
tjrkdeogkrry
가다나라마바사(6)
rkskekfkakqktk
릴릴릴릴(0)
flfflfflfflf
문제를(2)
answpfmf*/