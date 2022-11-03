package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_01544_CycleWords {

	static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			String input = br.readLine();
			check(input);
		}

		System.out.println(list.size());
	}

	private static void check(String str) {

		List<String> tmp_list = new ArrayList<>();

		if (list.isEmpty()) {
			list.add(str);
		} else {
			// making tmp_list
			for (int i = 0; i < str.length(); i++) {
				String tmp = "";
				tmp += str.charAt(i); // the first

				// the rest
				for (int j = i + 1; j < str.length(); j++) {
					tmp += str.charAt(j);
				}

				for (int j = 0; j < i; j++) {
					tmp += str.charAt(j);
				}

				tmp_list.add(tmp);

			}

			boolean flag = true;
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < tmp_list.size(); j++) {
					if (list.get(i).equals(tmp_list.get(j))) {
						flag = false;
					}
				}
			}

			if (flag)
				list.add(str);

		}
	}

}
