package BOJ;

import java.util.Scanner;

public class BOJ_02998_Octal {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		input = justifying_length(input);
		to_octal(input);
	}

	private static String justifying_length(String input) {
		if (input.length() % 3 == 0) {

		} else if (input.length() % 3 == 1) {
			input = "00" + input;
		} else if (input.length() % 3 == 2) {
			input = "0" + input;
		}
		return input;
	}

	private static void to_octal(String input) {
		StringBuilder sb = new StringBuilder();
		String temp = "";

		for (int i = 0; i < input.length(); i = i + 3) {
			temp = input.substring(i, i + 3);
			switch (temp) {
			case "000":
				sb.append("0");
				break;
			case "001":
				sb.append("1");
				break;
			case "010":
				sb.append("2");
				break;
			case "011":
				sb.append("3");
				break;
			case "100":
				sb.append("4");
				break;
			case "101":
				sb.append("5");
				break;
			case "110":
				sb.append("6");
				break;
			case "111":
				sb.append("7");
				break;
			}
		}

		System.out.println(sb);

	}

}
