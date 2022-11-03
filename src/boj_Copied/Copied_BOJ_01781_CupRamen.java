package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_01781_CupRamen {

	static class Problem implements Comparable<Problem> {
		int deadLine;
		int ramen;

		Problem(int deadLine, int ramen) {
			this.deadLine = deadLine;
			this.ramen = ramen;
		}

		@Override
		public int compareTo(Problem o) {
			if (this.deadLine == o.deadLine) {
				return o.ramen - this.ramen;
			}
			return this.deadLine - o.deadLine;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		List<Problem> list = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int deadLine = Integer.parseInt(st.nextToken());
			int ramen = Integer.parseInt(st.nextToken());

			list.add(new Problem(deadLine, ramen));
		}

		Collections.sort(list);

		for (Problem problem : list) {
			int size = pq.size();
			if (size < problem.deadLine) {
				pq.offer(problem.ramen);
			} else if (size == problem.deadLine) {
				int cnt = pq.peek();
				if (cnt < problem.ramen) {
					pq.poll();
					pq.offer(problem.ramen);
				}
			}
		}

		long ans = 0;
		while (!pq.isEmpty()) {
			ans += pq.poll();
		}

		System.out.println(ans);

	}

}

// reference: https://maivve.tistory.com/318
