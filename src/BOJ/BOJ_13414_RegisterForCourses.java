package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_13414_RegisterForCourses {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		Set<String> set = new LinkedHashSet<>();

		while (L-- > 0) {
			String str = br.readLine();
			set.add(str);

			if (set.contains(str)) {
				set.remove(str);
				set.add(str);
			}
		}

		Iterator<String> iterator = set.iterator();
		int cnt = 0;
		while (iterator.hasNext()) {
			sb.append(iterator.next()).append('\n');
			cnt++;
			if (cnt == K)
				break;
		}

		System.out.println(sb.toString());
	}

}
