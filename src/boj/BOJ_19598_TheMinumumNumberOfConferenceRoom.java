package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19598_TheMinumumNumberOfConferenceRoom {

	static class Node implements Comparable<Node> {
		int s, e;

		Node(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Node o) {
			return this.s - o.s;
		}

		@Override
		public String toString() {
			return "Node [s=" + s + ", e=" + e + "]";
		}

	}

	static List<Node> list = new ArrayList<>();
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new Node(s, e));
		}

		Collections.sort(list);

//		for (int i = 0; i < N; i++) {
//			System.out.println(list.get(i));
//		}

		for (int i = 0; i < N; i++) {
			while (!pq.isEmpty() && pq.peek() <= list.get(i).s) {
				pq.poll();
			}

			pq.add(list.get(i).e);
			ans = Math.max(ans, pq.size());
		}

		System.out.println(ans);
	}

}
