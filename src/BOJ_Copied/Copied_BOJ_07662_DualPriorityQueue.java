package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_07662_DualPriorityQueue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int k = Integer.parseInt(br.readLine());
			Map<Integer, Integer> map = new HashMap<>();
			PriorityQueue<Integer> minQue = new PriorityQueue<>();
			PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				char op = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());

				if (op == 'I') {
					map.put(n, map.getOrDefault(n, 0) + 1);

					minQue.add(n);
					maxQue.add(n);
					
				} else {
					if (map.size() == 0)
						continue;

					PriorityQueue<Integer> que = n == 1 ? maxQue : minQue;
					removeMap(que, map);
				}
			}

			if (map.size() == 0)
				System.out.println("EMPTY");
			else {
				int n = removeMap(maxQue, map);
				System.out.println(n + " " + (map.size() > 0 ? removeMap(minQue, map) : n));
			}

		}

	}

	private static int removeMap(PriorityQueue<Integer> que, Map<Integer, Integer> map) {
		int num;
		while (true) {
			num = que.poll();
			int cnt = map.getOrDefault(num, 0);

			if (cnt == 0)
				continue;

			if (cnt == 1)
				map.remove(num);
			else
				map.put(num, cnt - 1);

			break;
		}

		return num;
	}

}

// reference: https://girawhale.tistory.com/14
