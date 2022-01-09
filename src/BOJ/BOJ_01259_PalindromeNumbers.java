package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01259_PalindromeNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String input = br.readLine();
			if (input.equals("0")) {
				break;
			}
			char[] input_arr = input.toCharArray();

			StringBuilder sb = new StringBuilder(input);
			String reverse = sb.reverse().toString();
			char[] reverse_arr = reverse.toCharArray();

			Boolean flag = true;
			for (int i = 0; i < input_arr.length; i++) {
				if (input_arr[i] != reverse_arr[i]) {
					flag = false;
				}
			}

			for (int i = 0; i < input_arr.length; i++) { // excluding the case that the number starts from the '0'
				if (input_arr[0] == '0' && input_arr[i] != '0') {
					flag = false;
				}
			}

			if (flag == true) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}

	}

}
