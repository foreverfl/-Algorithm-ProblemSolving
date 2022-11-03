package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_22252_InformationMerchantHoseok {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();

		long ans = 0;

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();

			if (type.equals("1")) {
				String name = st.nextToken();
				int k = Integer.parseInt(st.nextToken());
				if (map.containsKey(name)) {
					PriorityQueue<Integer> tmp = map.get(name);
					for (int i = 0; i < k; i++) {
						tmp.offer(Integer.parseInt(st.nextToken()));
					}
					map.put(name, tmp);
				} else {
					PriorityQueue<Integer> tmp = new PriorityQueue<>(Collections.reverseOrder());
					for (int i = 0; i < k; i++) {
						tmp.offer(Integer.parseInt(st.nextToken()));
					}
					map.put(name, tmp);
				}

			} else {
				String name = st.nextToken();
				int b = Integer.parseInt(st.nextToken());

				PriorityQueue<Integer> tmp = map.get(name);
				if(tmp == null)
					continue;
				
				while (b-- > 0 && !tmp.isEmpty()) {
					ans += tmp.poll();
				}
			}

		}

		System.out.print(ans);
	}

}
