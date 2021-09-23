package BOJ;

import java.util.Scanner;

public class Copied_BOJ_01316_GroupWordsChecker {

	static Scanner sc = new Scanner(System.in); // the 'Scanner' is used in a variety of methods.

	public static void main(String[] args) {

		int count = 0;
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			if (check() == true) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean check() {
		boolean[] check = new boolean[26]; // true ¡æ exist. false ¡æ don't exist.
		int previous = 0;
		String str = sc.next();

		for (int i = 0; i < str.length(); i++) {
			int now = str.charAt(i);

			if (previous != now) { // if the 'previous' and the 'now' are not same,

				if (check[now - 'a'] == false) { // if the 'now' comes first(if the 'now' is false),
					check[now - 'a'] = true; // changes to true
					previous = now; // for next turn
				} else {
					return false;
				}
			}

			else {
				continue;
			}
		}
		return true;
	}
}
