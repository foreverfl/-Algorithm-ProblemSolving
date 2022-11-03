package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_01374_Classroom {

	static class Lecture implements Comparable<Lecture> {
		int n, s, e;

		Lecture(int n, int s, int e) {
			this.n = n;
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Lecture o) {
			return this.s - o.s;
		}

		@Override
		public String toString() {
			return "Lecture [n=" + n + ", s=" + s + ", e=" + e + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		List<Lecture> list = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // saving ends

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new Lecture(n, s, e));
		}

		Collections.sort(list);

		int max = Integer.MIN_VALUE;

//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}

		for (int i = 0; i < N; i++) {
			while (!pq.isEmpty() && pq.peek() <= list.get(i).s) {
				pq.poll();
			}

			pq.add(list.get(i).e);
			max = Math.max(max, pq.size());
		}

		System.out.println(max);
	}

}

// reference: https://nkt-docs.tistory.com/27