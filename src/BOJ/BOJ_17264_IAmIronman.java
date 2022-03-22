package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17264_IAmIronman {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());

		HashMap<String, String> hashmap = new HashMap<>();

		while (P-- > 0) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String condition = st.nextToken();

			hashmap.put(name, condition);
		}

		int score = 0;
		while (N-- > 0) {
			String name = br.readLine();
			if (hashmap.containsKey(name)) {

				if (hashmap.get(name).equals("W"))
					score += W;
				else
					score -= L;
			} else {
				score -= L;
			}

			if (score < 0)
				score = 0;

			if (score >= G) {
				System.out.println("I AM NOT IRONMAN!!");
				return;
			}
		}

		System.out.println("I AM IRONMAN!!");

	}

}
