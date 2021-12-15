package BOJ_incomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_01541_Lostparentheses {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = Integer.MAX_VALUE; // It checks an initial condition.
		String[] subtraction = br.readLine().split("-");

		for (int i = 0; i < subtraction.length; i++) {
			int temp = 0;

			String[] addition = subtraction[i].split("\\+"); // It adds tokens within tokens divided with subtraction.

			for (int j = 0; j < addition.length; j++) { // It adds all tokens in the tokens divided with subtraction
				temp += Integer.parseInt(addition[j]);
			}

			if (sum == Integer.MAX_VALUE) { // The first token must be the initial value.
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}

}
