package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_07567_Bowl {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(bowl(input));
	}

	private static int bowl(String input) {
		char[] input_arr = input.toCharArray();
		int result = 10; // The first value is '10'.

		for (int i = 0; i < input_arr.length - 1; i++) {
			if (input_arr[i] == '(') {
				if (input_arr[i + 1] == '(') {
					result += 5;
				} else if (input_arr[i + 1] == ')') {
					result += 10;
				}
			}

			if (input_arr[i] == ')') {
				if (input_arr[i + 1] == ')') {
					result += 5;
				} else if (input_arr[i + 1] == '(') {
					result += 10;
				}
			}
		}

		return result;
	}

}
