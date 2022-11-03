package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01526_FourAndSeven {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		while (true) {

			if (check(input))
				break;
			
			input--;
		}

		System.out.println(input);

	}

	private static boolean check(int input) {

		String tmp = Integer.toString(input);

		boolean flag = true;

		for (int i = 0; i < tmp.length(); i++) {
			if (tmp.charAt(i) != '4' && tmp.charAt(i) != '7') {
				flag = false;
			}
		}

		return flag;
	}

}
