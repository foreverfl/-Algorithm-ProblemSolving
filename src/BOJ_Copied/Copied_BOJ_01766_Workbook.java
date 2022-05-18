package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_01766_Workbook {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] indegree = new int[N + 1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());

			list.get(first).add(last);
			indegree[last]++; // the number of problems to solve first than other problems
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				pq.offer(i);
			}
		}

		while (!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now + " ");

			for (int next : list.get(now)) {

				indegree[next]--;

				if (indegree[next] == 0) {
					pq.offer(next);
				}
			}
		}

		System.out.println(sb.toString());

	}

}

// reference: https://steady-coding.tistory.com/85