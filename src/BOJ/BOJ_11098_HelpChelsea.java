package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_11098_HelpChelsea {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			int p = Integer.parseInt(br.readLine());

			HashMap<Integer, String> hashmap = new HashMap<>();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < p; i++) {
				st = new StringTokenizer(br.readLine());
				int price = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				if (price >= max)
					max = price;

				hashmap.put(price, name);
			}

			sb.append(hashmap.get(max)).append('\n');
		}

		System.out.println(sb.toString());
	}

}
