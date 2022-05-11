package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BOJ_03300_MooreMachine {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String pattern = br.readLine();
			String output = br.readLine();

			int cnt = 0;
			char ans = ' ';

			for (char c = 'A'; c <= 'Z'; c++) {
				String tmp = pattern.replace('_', c);

				if (Pattern.matches(tmp, output)) {
					ans = c;
					cnt++;
				}
			}

			if (cnt > 1)
				sb.append('_').append('\n');
			else if (cnt == 0)
				sb.append('!').append('\n');
			else if (cnt == 1)
				sb.append(ans).append('\n');
		}

		System.out.println(sb.toString());
	}

}

// reference: https://unfunhy.tistory.com/81?category=825141
