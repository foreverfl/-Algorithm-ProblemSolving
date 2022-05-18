package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_02628_CuttingPaper {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		List<Integer> cutHorizontally = new ArrayList<>();
		List<Integer> cutVertically = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		cutHorizontally.add(H);
		cutVertically.add(W);
		cutHorizontally.add(0);
		cutVertically.add(0);

		int C = Integer.parseInt(br.readLine());
		while (C-- > 0) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			int where = Integer.parseInt(st.nextToken());

			if (check == 0) {
				cutHorizontally.add(where);
			} else {
				cutVertically.add(where);
			}
		}

		Collections.sort(cutHorizontally);
		Collections.sort(cutVertically);

		int max_h = Integer.MIN_VALUE;
		for (int i = cutHorizontally.size() - 1; i > 0; i--) {
			max_h = Math.max(max_h, cutHorizontally.get(i) - cutHorizontally.get(i - 1));
		}

		int max_v = Integer.MIN_VALUE;
		for (int i = cutVertically.size() - 1; i > 0; i--) {
			max_v = Math.max(max_v, cutVertically.get(i) - cutVertically.get(i - 1));
		}

		int result = max_h * max_v;

		System.out.println(result);

	}

}
