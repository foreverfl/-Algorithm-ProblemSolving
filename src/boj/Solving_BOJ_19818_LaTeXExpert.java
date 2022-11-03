package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solving_BOJ_19818_LaTeXExpert {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String str = "";
		String text = "";
		while (true) {
			str = br.readLine();
			if (str.equals("\\begin{thebibliography}{99}"))
				break;

			text += str + '\n';

		}

		List<String> list = new LinkedList<>();
		String bibliography = "";
		bibliography += str + '\n';
		while (true) {
			str = br.readLine();
			list.add(str);
			bibliography += str + '\n';
			if (str.equals("\\end{thebibliography}"))
				break;
		}

		Queue<String> queue = new LinkedList<>();
		Pattern pattern = Pattern.compile("(\\{(.+?)\\})"); //
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			queue.add(matcher.group());
		}

		String ans = "";
		ans += "\\begin{thebibliography}{99}" + '\n';
		String tmp = "";
		while (!queue.isEmpty()) {
			tmp = queue.poll();
			for (int i = 0; i < list.size(); i++) {
				st = new StringTokenizer(list.get(i));
				if (st.nextToken().contains(tmp)) {
					String rest = "";
					while (st.hasMoreTokens()) {
						rest += st.nextToken() + " ";
					}
					ans += "\\bibitem" + tmp + " " + rest + '\n';
				}
			}
		}

		ans += "\\end{thebibliography}";

		pattern = Pattern.compile("(\\{(.+?)\\})"); //
		matcher = pattern.matcher(bibliography);
		while (matcher.find()) {
			String tmp_matcher = matcher.group();
			queue.add(tmp_matcher);
		}
		matcher = pattern.matcher(ans);
		while (matcher.find()) {
			String tmp_matcher = matcher.group();
			if (tmp_matcher.equals(queue.peek())) {
				queue.poll();
			}
		}

		if (queue.isEmpty())
			sb.append("Correct");
		else {
			sb.append("Incorrect").append('\n');
			sb.append(ans);
		}

		System.out.println(sb.toString());
	}

}
