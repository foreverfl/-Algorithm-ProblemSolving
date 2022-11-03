package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_05800_ClassStatistics {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine());
		for (int i = 1; i <= K; i++) {
			List<Integer> list = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			while (N-- > 0) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			Collections.sort(list, Collections.reverseOrder());

			int max = list.get(0);
			int min = list.get(list.size() - 1);

			int gap = Integer.MIN_VALUE;
			for (int j = 0; j < list.size() - 1; j++) {
				int tmp = Math.abs(list.get(j) - list.get(j + 1));
				gap = Math.max(gap, tmp);
			}

			sb.append("Class " + i).append('\n');
			sb.append("Max " + max + ", Min " + min + ", Largest gap " + gap).append('\n');
		}

		System.out.println(sb.toString());
	}

}
