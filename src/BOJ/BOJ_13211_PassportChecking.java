package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_13211_PassportChecking {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>();

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			String str = br.readLine();
			set.add(str);
		}

		int cnt = 0;
		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			String str = br.readLine();
			if (set.contains(str))
				cnt++;
		}

		System.out.println(cnt);

	}

}
