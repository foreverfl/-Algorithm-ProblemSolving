package boj_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Copied_BOJ_01700_MultitapScheduling {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] electronics = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			electronics[i] = Integer.parseInt(st.nextToken());
		}

		boolean[] use = new boolean[101];
		int put = 0;
		int ans = 0;
		for (int i = 0; i < K; i++) {
			int temp = electronics[i];

			if (!use[temp]) { // If the plug is not used.
				if (put < N) { // If there is space to put a plug.
					use[temp] = true;
					put++;
				} else { // If there is not space to put a plug.

					ArrayList<Integer> list = new ArrayList<>();
					for (int j = i; j < K; j++) { // checking the current plug will be used later.
						if (use[electronics[j]] && !list.contains(electronics[j])) {
							list.add(electronics[j]);
						}
					}

					if (list.size() != N) { // If the current plug is 'not' used later.
						for (int j = 0; j < use.length; j++) {
							if (use[j] && !list.contains(j)) { 
								use[j] = false; // removing the current one
								break;
							}
						}
					} else { // If the current plug is used later.
						int remove = list.get(list.size() - 1); // removing the last
						use[remove] = false;
					}

					use[temp] = true;
					ans++;
				}
			}
		}

		sb.append(ans);
		System.out.println(sb.toString());
	}

}

// reference: https://steady-coding.tistory.com/55
