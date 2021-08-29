package baekjoon;

import java.util.Scanner;

public class _1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strInput = sc.nextLine();
		strInput = strInput.trim(); // 'trim()' eliminates blank on both ends.
		Boolean checkEmpty = false; // It checks whether 'strInput' consists of only blanks.
		int result = 0;

		for (int tmp = 0; tmp < strInput.length(); tmp++) { // '.length' can be used in a string type.
			if (strInput.charAt(tmp) == ' ' && strInput.charAt(tmp - 1) != ' ') {
				// It finds spacing and checks whether there is spacing right in front of
				// strings.
				result++;
			} else {
				checkEmpty = true;
			}
		}

		if (checkEmpty) {
			System.out.println(result + 1);
		} else {
			System.out.println(result);
		}
		sc.close();
	}

}
