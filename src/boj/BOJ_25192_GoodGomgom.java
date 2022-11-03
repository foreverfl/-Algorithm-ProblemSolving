package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class BOJ_25192_GoodGomgom {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new TreeSet<>();

		int ans = 0;
		while (N-- > 0) {

			String str = br.readLine();
			if (str.equals("ENTER")) {
				ans += set.size();
				set.clear();
			} else {
				set.add(str);
			}
		}
		
		ans += set.size();

		System.out.print(ans);
	}

}
