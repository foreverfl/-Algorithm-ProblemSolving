package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_10165_BusRoute {

	static class Route implements Comparable<Route> {
		int idx;
		int s;
		int e;

		public Route(int idx, int s, int e) {
			this.idx = idx;
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Route o) {
			if (this.s == o.s) {
				return o.e - this.e;
			}
			return this.s - o.s;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int last = 0;
		List<Route> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			if (s > e) { // route passing start stop
				last = Math.max(last, e);
				e += N;
			}
			list.add(new Route(i + 1, s, e));
		}

		Deque<Route> deque = new ArrayDeque<>();
		Collections.sort(list);

		// the first filtering
		for (Route route : list) {
			if (deque.isEmpty() || deque.getLast().e < route.e) { // i.e < i+1.e
				deque.add(route);
			}
		}
		// the second filtering
		while (!deque.isEmpty() && deque.getFirst().e <= last) { // i.e <= last
			deque.removeFirst();
		}

		List<Integer> res = new ArrayList<>();
		while (!deque.isEmpty()) {
			res.add(deque.poll().idx);
		}

		Collections.sort(res, (a, b) -> (a - b));
		for (int idx : res) {
			System.out.print(idx + " ");
		}
	}
}

// reference: https://loosie.tistory.com/311
