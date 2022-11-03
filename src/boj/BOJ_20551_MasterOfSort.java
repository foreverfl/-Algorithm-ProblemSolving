package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_20551_MasterOfSort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		while (N-- > 0) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		Map<Integer, Integer> map = new TreeMap<>();

		int idx = 0;
		while (!pq.isEmpty()) {
			if (map.containsKey(pq.peek())) {
				pq.poll();
			} else {
				map.put(pq.poll(), idx);
			}
			idx++;

		}

		while (M-- > 0) {
			int input = Integer.parseInt(br.readLine());
			int result = map.getOrDefault(input, -1);
			sb.append(result).append('\n');
		}

		System.out.println(sb.toString());

	}

}
