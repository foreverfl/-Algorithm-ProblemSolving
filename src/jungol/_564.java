package jungol;

import java.util.Scanner;

public class _564 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26];

		for (int i = 0; i < 26; i++) {
			arr[i] = 0;
		}

		while (true) {
			char ch = sc.next().charAt(0);
			if (ch < 'A' || ch > 'Z')
				break;
			arr[(int) ch - 65]++; // To convert alphabets into integers, casting is used.
								  // (int) A = 65
		}

		for (int i = 0; i < 26; i++) {
			if (arr[i] != 0) {
				System.out.println((char)(int)(i+65) + " : " + arr[i]);
			}
		}
		sc.close();
	}

}
