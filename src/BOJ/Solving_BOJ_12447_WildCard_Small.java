package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solving_BOJ_12447_WildCard_Small {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int idx = 0;
		while (T-- > 0) {

			List<String> A_pattern = new ArrayList<>();
			List<String> A_pattern_matched = new ArrayList<>();

			idx++;
			String A = br.readLine();
			String B = br.readLine();

			A_pattern.add(A);
			
			int A_start = 0;
			int A_end = A.length();
			while (true) {
				A_start++;
				for (int i = 0; i < A_end; i++) {
					StringBuilder tmp = new StringBuilder(A);
					A_pattern.add(tmp.replace(i, i + A_start, "*").toString());
				}
				A_end--;

				if (A_start == A.length())
					break;
			}
			
//			 **aa
//			a**a
//			ab**
//			a*a*
//			*b*a
//			*ba*
			// * 이 서로 떨어져 있는 경우 고려가 안됨

			for (int i = 0; i < A_pattern.size(); i++) {
				String pattern = A_pattern.get(i);

				pattern = pattern.replaceAll("\\*", ".*");

				if (!B.matches(pattern)) {
					pattern = pattern.replaceAll("\\.", "");
					A_pattern_matched.add(pattern);
				}
			}

			Collections.sort(A_pattern_matched, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return Integer.compare(o1.length(), o2.length());
				}

			});
			
			sb.append("Case #" + idx + ": " + A_pattern_matched.get(0)).append('\n');
		}

		System.out.println(sb.toString());
	}

}
