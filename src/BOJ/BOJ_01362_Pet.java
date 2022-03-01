package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01362_Pet {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int optimal = 0;
		int real = 0;
		int T = 0;
		String str = "";

		while (!(str = br.readLine()).equals("0 0")) {

			st = new StringTokenizer(str);
			String a = st.nextToken();
			String b = st.nextToken();

			if (isNumeric(a)) {
				optimal = Integer.parseInt(a);
				real = Integer.parseInt(b);

				while (isNumeric(a)) {

					st = new StringTokenizer(br.readLine());
					String activity = st.nextToken();
					int n = Integer.parseInt(st.nextToken());

					if (activity.equals("F")) {

						real += n;

					} else if (activity.equals("E")) {
						real -= n;

						if (real <= 0) {
							break;
						}

					} else if (activity.equals("#")) {
						break;
					}

				}
				
			} else {
				
				continue;
				
			}

			T++;
			sb.append(T + " ");

			if ((real > optimal / 2) && (real < optimal * 2)) {
				sb.append(":-)").append('\n');
			} else if (real <= 0) {
				sb.append("RIP").append('\n');
			} else {
				sb.append(":-(").append('\n');
			}

		}

		System.out.println(sb.toString());
	}

	private static boolean isNumeric(String str) {
		boolean result = true;
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				result = false;
			}
		}

		return result;
	}

}
