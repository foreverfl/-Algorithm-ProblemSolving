package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_09576_DistributingBooks {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			boolean[] check = new boolean[N + 1];
			List<int[]> list = new ArrayList<>();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				list.add(new int[] { A, B });
			}

			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});

			int total = 0;
			for (int[] num : list) {
				int start = num[0];
				int end = num[1];
				for (int i = start; i <= end; i++) {
					if (!check[i]) {
						check[i] = true;
						total++;
						break;
					}
				}
			}
			sb.append(total + "\n");
		}
		System.out.println(sb.toString());
	}

}

// reference: https://loosie.tistory.com/531