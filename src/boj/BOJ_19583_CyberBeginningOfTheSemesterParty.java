package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_19583_CyberBeginningOfTheSemesterParty {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		String S = st.nextToken();
		String E = st.nextToken();
		String Q = st.nextToken();

		Set<String> before = new HashSet<>();
		Set<String> after = new HashSet<>();
		Set<String> member = new HashSet<>();
	
		String str = null;
		while ((str = br.readLine()) != null) {
			
			st = new StringTokenizer(str);
			String time = st.nextToken();
			String name = st.nextToken();

			member.add(name);
			if (S.compareTo(time) >= 0) {
				before.add(name);
			} else if (E.compareTo(time) <= 0 && Q.compareTo(time) >= 0) {
				after.add(name);
			}
		}

		int ans = 0;
		for (String name : member) {
			if (before.contains(name) && after.contains(name)) {
				ans += 1;
			}
		}
		System.out.println(ans);
	}
}

// reference: https://codeung.tistory.com/312
