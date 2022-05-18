package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_04889_StableString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int idx = 0;
		while (true) {
			idx++;

			String str = br.readLine();
			if (str.charAt(0) == '-')
				break;

			int cnt = 0;
			while (str.contains("{}"))
				str = str.replaceFirst("\\{\\}", "");

			while (str.contains("{{")) {
				str = str.replaceFirst("\\{\\{", "");
				cnt++;
			}

			while (str.contains("}}")) {
				str = str.replaceFirst("\\}\\}", "");
				cnt++;
			}

			cnt += str.length();

			sb.append(idx + ". " + cnt).append('\n');

		}

		System.out.println(sb.toString());
	}

}
