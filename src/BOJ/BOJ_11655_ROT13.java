package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11655_ROT13 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		System.out.println(ROT13(input));
	}

	private static String ROT13(String input) {
		char[] input_arr = input.toCharArray();
		char[] result_arr = new char[input_arr.length];
		for (int i = 0; i < input_arr.length; i++) {
			// lower case
			if (input_arr[i] <= 'm' && input_arr[i] >= 'a') {
				result_arr[i] = (char) (input_arr[i] + 13);

			}

			if (input_arr[i] > 'm' && input_arr[i] <= 'z') {
				int temp = 'z' - input_arr[i];
				result_arr[i] = (char) ('a' + 12 - temp); // Because the calculation starts from 'a', '13' has to be added instead of '12' 

			}

			// upper case
			if (input_arr[i] <= 'M' && input_arr[i] >= 'A') {
				result_arr[i] = (char) (input_arr[i] + 13);

			}

			if (input_arr[i] > 'M' && input_arr[i] <= 'Z') {
				int temp = 'Z' - input_arr[i];
				result_arr[i] = (char) ('A' + 12 - temp);

			}
			
			// number
			if (input_arr[i] >= '0' && input_arr[i] <= '9') {
				result_arr[i] = input_arr[i];

			}
			
			// blank
			if (input_arr[i] == ' ') {
				result_arr[i] = input_arr[i];

			}

		}

		String result = "";
		for (int i = 0; i < result_arr.length; i++) {
			String charToString = Character.toString(result_arr[i]);
			result += charToString;
		}

		return result;
	}
}
