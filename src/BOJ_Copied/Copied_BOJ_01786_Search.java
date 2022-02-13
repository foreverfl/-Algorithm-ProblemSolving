package BOJ_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Copied_BOJ_01786_Search {

	static int cnt = 0;
	static List<Integer> li;

	static int[] getPi(String ptn) {
		int[] pi = new int[ptn.length()];
		int j = 0;
		for (int i = 1; i < ptn.length(); i++) {
			while (j > 0 && ptn.charAt(i) != ptn.charAt(j)) {
				j = pi[j - 1];
			}
			if (ptn.charAt(i) == ptn.charAt(j))
				pi[i] = ++j;
		}
		return pi;
	}

	static void KMP(String org, String ptn) {
		int pi[] = getPi(ptn);
		int j = 0;
		for (int i = 0; i < org.length(); i++) {
			while (j > 0 && org.charAt(i) != ptn.charAt(j)) {
				j = pi[j - 1];
			}
			if (org.charAt(i) == ptn.charAt(j)) {
				if (j == ptn.length() - 1) {
					++cnt;
					li.add(i - j + 1); // saving index position
					j = pi[j]; // initialization
				} else
					j++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String pattern = br.readLine();
		li = new ArrayList<>();
		KMP(origin, pattern);
		System.out.println(cnt);
		for (int i = 0; i < cnt; i++)
			System.out.println(li.get(i));
	}
}

// reference: https://imnotabear.tistory.com/118

// theory: https://devje8.tistory.com/24