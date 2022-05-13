package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14235_ChristmasPresent {

	static List<Integer> presents = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {

			String str = br.readLine();

			if (str.equals("0")) {

				Collections.sort(presents, Collections.reverseOrder());

				if (!presents.isEmpty()) {
					sb.append(presents.get(0)).append('\n');
					presents.remove(0);
				} else
					sb.append("-1").append('\n');

			} else {

				st = new StringTokenizer(str);
				int a = Integer.parseInt(st.nextToken());
				while (a-- > 0) {
					presents.add(Integer.parseInt(st.nextToken()));
				}
			}

		}

		System.out.println(sb.toString());
	}

}
