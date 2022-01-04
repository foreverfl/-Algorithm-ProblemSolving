package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11470_EasyArithmetic {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		// adding '+'
		String[] arr = input.split("");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("-")) {
				arr[i + 1] = arr[i + 1] + "+";
			}
		}
		input = String.join("", arr);

		// Numbers have no leading zeroes.
		for (int i = 0; i < arr.length - 1; i++) {
			arr = input.split("");
			if (arr[i].equals("+") && arr[i + 1].equals("0")) {
				arr[i + 1] = "0+";
			}

			input = String.join("", arr);
		}
		// There are no two consecutive signs.
		arr = input.split("");
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].equals("+") && arr[i + 1].equals("+")) {
				arr[i] = "";
			}
			if (arr[i].equals("-") && arr[i + 1].equals("-")) {
				arr[i] = "";
			}
			if (arr[i].equals("+") && arr[i + 1].equals("-")) {
				arr[i] = "";
			}
			if (arr[i].equals("-") && arr[i + 1].equals("+")) {
				arr[i] = "";
			}
		}
		input = String.join("", arr);

		// The last character of the expression is a digit.
		arr = input.split("");
		if (arr[arr.length - 1].equals("+") || arr[arr.length - 1].equals("-"))
			arr[arr.length - 1] = "";
		input = String.join("", arr);

		System.out.println(input);

	}
}