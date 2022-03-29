package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_02661_GoodProgression {

	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		backtracking("");
	}

	private static void backtracking(String result) {
		if (result.length() == N) {
			System.out.println(result);
			System.exit(0);

		} else {
			for (int i = 1; i <= 3; i++) {
				if (isGoodSequence(result + i)) {
					backtracking(result + i);
				}
			}
		}
	}

	
	// abcdef
	// e - f
	// cd - ef
	/// abc - def
	private static boolean isGoodSequence(String str) {
		int length = str.length() / 2;

		for (int i = 1; i <= length; i++) {
			if (str.substring(str.length() - i).equals(str.substring(str.length() - 2 * i, str.length() - i))) {
				return false;
			}
		}

		return true;
	}
}

// reference: https://bellog.tistory.com/43