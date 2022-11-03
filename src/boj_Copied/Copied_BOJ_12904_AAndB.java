package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_12904_AAndB {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer start = new StringBuffer(br.readLine());
		StringBuffer target = new StringBuffer(br.readLine());

		// target -> start
		while (start.length() < target.length()) {
			if (target.charAt(target.length() - 1) == 'A') {
				target.deleteCharAt(target.length() - 1);
			} else if (target.charAt(target.length() - 1) == 'B') {
				target.deleteCharAt(target.length() - 1);
				target.reverse();
			}
		}

		if (start.toString().equals(target.toString())) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}

// reference: https://settembre.tistory.com/253