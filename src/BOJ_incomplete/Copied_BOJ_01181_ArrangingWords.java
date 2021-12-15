package BOJ_incomplete;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Copied_BOJ_01181_ArrangingWords {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String[] arr = new String[N];

		sc.nextLine(); // preventing the 'Scanner' error

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextLine();
		}

		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				// if length of a word is same
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				// otherwise
				else {
					return s1.length() - s2.length();
				}
			}
		});

		System.out.println(arr[0]); // handling the 'IndexOutOfBoundsException'

		for (int i = 1; i < N; i++) { // handling the 'IndexOutOfBoundsException'
			if (!arr[i].equals(arr[i - 1])) { // It prints words which are not duplicated.
				System.out.println(arr[i]);
			}
		}
	}

}
