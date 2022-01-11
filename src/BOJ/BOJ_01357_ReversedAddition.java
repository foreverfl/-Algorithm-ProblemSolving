package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01357_ReversedAddition {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String X = st.nextToken();
		String Y = st.nextToken();
		System.out
				.println(Integer.parseInt(rev(String.valueOf((Integer.parseInt(rev(X)) + Integer.parseInt(rev(Y)))))));

	}

	private static String rev(String input) {
		StringBuilder sb = new StringBuilder(input);
		String result = sb.reverse().toString();
		return result;
	}

}
