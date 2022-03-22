package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_01972_SurprisingStrings {

	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();

			if (str.equals("*"))
				break;
			
			backtracking(str, 1);

			set.clear();

			
		}

		System.out.println(sb.toString());
	}

	private static void backtracking(String str, int depth) { // The 'depth' means a distance between each character.
		if (depth == str.length()) {
			sb.append(str + " is surprising.").append('\n');
			return;
		}

		for (int i = 0; i < str.length() - depth; i++) {
			String tmp = "";
			for (int j = i;; j = j + depth) {
				char tmp_char = str.charAt(j);
				tmp += tmp_char;
				if (tmp.length() == 2)
					break;
			}
			if (set.contains(tmp)) {
				sb.append(str + " is NOT surprising.").append('\n');
				return;
			} else {
				set.add(tmp);
			}
		}
		
		set.clear();
		
		backtracking(str, depth + 1);

	}

}
