package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_01384_Message {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int group = 0;
		String str = br.readLine();

		loop: while (true) {
			while (Character.isDigit(str.charAt(0))) {
				sb.append("Group " + ++group).append('\n');
				int N = Integer.parseInt(str);
				List<String> student = new ArrayList<>();
				List<Character>[] paper = new ArrayList[N + 1];

				for (int i = 0; i < N; i++) {

					st = new StringTokenizer(br.readLine());
					student.add(st.nextToken());

					paper[i] = new ArrayList<>();
					for (int j = 0; j < N - 1; j++) {
						paper[i].add(st.nextToken().charAt(0));
					}

				}

				boolean flag = true;
				String A = "";
				String B = "";
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N - 1; j++) {

						B = student.get(i);

						if (paper[i].get(j) == 'N') {
							flag = false;
							if (i - j > 0) {
								A = student.get(i - j - 1); // to the back as much as 'j+1'
							} else {
								A = student.get(i - j + (N - 1));
							}
							sb.append(A + " was nasty about " + B).append('\n');
						}
					}

				}

				if (flag == true) {
					sb.append("Nobody was nasty").append('\n');
				}
				sb.append('\n');

				str = br.readLine();

				if (str.equals("0"))
					break loop;
			}
		}

		System.out.println(sb.toString());
	}

}
