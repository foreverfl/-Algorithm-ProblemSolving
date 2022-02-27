package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_01811_AdjacentMastermind {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int black = 0, grey = 0, white = 0;

		Set<Character> check_white = new HashSet<>();
		String target = "";
		String guess = "";
		String str = br.readLine();
		while (!str.equals("#")) {
			st = new StringTokenizer(str);
			target = st.nextToken();
			guess = st.nextToken();
			StringBuilder target_mod = new StringBuilder(target);
			StringBuilder guess_mod = new StringBuilder(guess);

			// black
			for (int i = 0; i < guess_mod.length(); i++) {
				if (guess_mod.charAt(i) == target_mod.charAt(i)) {
					target_mod = target_mod.replace(i, i + 1, "*");
					guess_mod = guess_mod.replace(i, i + 1, "*");
					black++;
				}
			}

			// grey
			String tmp = target_mod.toString();
			target_mod.setLength(0);
			target_mod.append(" " + tmp + " ");
			tmp = guess_mod.toString();
			guess_mod.setLength(0);
			guess_mod.append(" " + tmp + " ");

			for (int i = 1; i < guess_mod.length() - 1; i++) {
				if (guess_mod.charAt(i) != '*') {
					if (guess_mod.charAt(i) == target_mod.charAt(i - 1)) {
						target_mod = target_mod.replace(i - 1, i, "*");
						guess_mod = guess_mod.replace(i, i + 1, "*");
						grey++;

					}

					if (guess_mod.charAt(i) == target_mod.charAt(i + 1)) {
						target_mod = target_mod.replace(i + 1, i + 2, "*");
						guess_mod = guess_mod.replace(i, i + 1, "*");
						grey++;
					}

				}
			}

			// white
			tmp = guess_mod.toString().trim();
			guess_mod.setLength(0);
			guess_mod.append(tmp);
			tmp = target_mod.toString().trim();
			target_mod.setLength(0);
			target_mod.append(tmp);
			
			for (int i = 0; i < guess_mod.length(); i++) {
				if (guess_mod.charAt(i) != '*') {
					check_white.add(guess_mod.charAt(i));
				}
			}

			for (int i = 0; i < target_mod.length(); i++) {
				if (target_mod.charAt(i) != '*') {
					if (check_white.contains(target_mod.charAt(i))) {
						white++;
					}
				}
			}

			sb.append(guess + ": " + black + " black, " + grey + " grey, " + white + " white").append('\n');
			str = br.readLine();

			// initialization
			black = grey = white = 0;
			target_mod.setLength(0);
			guess_mod.setLength(0);
			check_white.clear();
		}

		System.out.println(sb.toString());
	}

}
