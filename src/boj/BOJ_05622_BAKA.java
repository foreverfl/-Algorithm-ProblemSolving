package boj;

import java.util.Scanner;

public class BOJ_05622_BAKA {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char arr[] = new char[str.length()];

		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
			cnt += Calculation(arr[i]);
		}
		System.out.println(cnt);

	}

	public static int Calculation(char cha) {
		if (cha == 'A' || cha == 'B' || cha == 'C') {
			return 3;
		} else if (cha == 'D' || cha == 'E' || cha == 'F') {
			return 4;
		} else if (cha == 'G' || cha == 'H' || cha == 'I') {
			return 5;
		} else if (cha == 'J' || cha == 'K' || cha == 'L') {
			return 6;
		} else if (cha == 'M' || cha == 'N' || cha == 'O') {
			return 7;
		} else if (cha == 'P' || cha == 'Q' || cha == 'R' || cha == 'S') {
			return 8;
		} else if (cha == 'T' || cha == 'U' || cha == 'V') {
			return 9;
		} else if (cha == 'W' || cha == 'X' || cha == 'Y' || cha == 'Z') {
			return 10;
		}
		return 0;
	}

}
