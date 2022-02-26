package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01284_HouseNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();
		while (!input.equals("0")) {

			sb.append(operation(input)).append('\n');

			input = br.readLine();
		}
		
		System.out.println(sb.toString());
	}

	private static int operation(String input) {
		int result = 2; // width of both sides

		int margin = input.length() - 1;
		result += margin;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '1')
				result += 2;
			else if (input.charAt(i) == '0')
				result += 4;
			else
				result += 3;
		}

		return result;
	}

}
