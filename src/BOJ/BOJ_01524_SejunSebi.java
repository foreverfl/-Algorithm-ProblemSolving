package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_01524_SejunSebi {

	static List<Integer> sejun = new ArrayList<>();
	static List<Integer> sebi = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			br.readLine();

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				sejun.add(Integer.parseInt(st.nextToken()));
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				sebi.add(Integer.parseInt(st.nextToken()));
			}

			game(sejun, sebi);

			if (sejun.isEmpty()) {
				sb.append("B").append('\n');
			} else if (sebi.isEmpty()) {
				sb.append("S").append('\n');
			}

			sejun.clear();
			sebi.clear();

		}

		System.out.println(sb.toString());
	}

	private static void game(List<Integer> sejun, List<Integer> sebi) {

		Collections.sort(sejun);
		Collections.sort(sebi);

		while (!sejun.isEmpty() && !sebi.isEmpty()) {

			if (!sejun.isEmpty() && !sebi.isEmpty()) { // processing error

				if (sejun.get(0) < sebi.get(0))
					sejun.remove(0);
				else
					sebi.remove(0);

			}

			if (!sejun.isEmpty() && !sebi.isEmpty()) {

				if (sejun.get(0) == sebi.get(0))
					sebi.remove(0);
			}
		}

	}

}