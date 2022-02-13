package BOJ;

import java.util.Scanner;

public class BOJ_10769_HappyOrSad {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] arr = input.split("");

		int happy_count = 0;
		int sad_count = 0;

		for (int i = 0; i < arr.length - 2; i++) {
			if (arr[i].equals(":") && arr[i + 1].equals("-") && arr[i + 2].equals(")")) {
				happy_count++;
			}
			if (arr[i].equals(":") && arr[i + 1].equals("-") && arr[i + 2].equals("(")) {
				sad_count++;
			}
		}

		if (happy_count == 0 && sad_count == 0) {
			System.out.println("none");
		} else if (happy_count == sad_count) {
			System.out.println("unsure");
		} else if (happy_count > sad_count) {
			System.out.println("happy");
		} else if (happy_count < sad_count) {
			System.out.println("sad");
		}

	}

}
