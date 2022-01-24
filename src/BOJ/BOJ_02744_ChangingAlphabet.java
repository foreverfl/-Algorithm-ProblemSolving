package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02744_ChangingAlphabet {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String result = "";

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= 'A' && input.charAt(i) < 'Z')
				result += (char) (input.charAt(i) + 32);
			else
				result += (char) (input.charAt(i) - 32);
		}

		System.out.println(result);
	}

}
