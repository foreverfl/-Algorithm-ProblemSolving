package boj_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_17140_TwoDimensionalArrayAndOp {

	static class Pair implements Comparable<Pair> {
		int number;
		int count;

		Pair(int n, int c) {
			this.number = n;
			this.count = c;
		}

		public int compareTo(Pair o) {
			if (this.count > o.count) {
				return 1;
			} else if (this.count == o.count) {
				return this.number - o.number;
			} else {
				return -1;
			}
		}
	}

	static int r, c, k;
	static int[][] A = new int[101][101];
	static int xLength = 3, yLength = 3; // the first value has to be the '3'.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= 3; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution());
	}

	private static int solution() {
		for (int time = 0; time <= 100; time++) {
			if (A[r][c] == k) {
				return time;
			}
			operating();
		}

		return -1;
	}

	private static void operating() {
		if (xLength >= yLength) {
			for (int i = 1; i <= xLength; i++) {
				R(i);
			}
		} else {
			for (int i = 1; i <= yLength; i++) {
				C(i);
			}
		}
	}

	private static void R(int key) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		Map<Integer, Integer> map = new HashMap<>(); // <number, count>

		for (int i = 1; i <= yLength; i++) {
			if (A[key][i] == 0)
				continue;
			map.compute(A[key][i], (num, count) -> count == null ? 1 : count + 1);
		}

		map.forEach((k, v) -> pq.add(new Pair(k, v)));

		int i = 1;
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			A[key][i++] = p.number;
			A[key][i++] = p.count;
		}

		yLength = Math.max(yLength, i);

		while (i <= 99) {
			A[key][i++] = 0;
			A[key][i++] = 0;
		}
	}

	private static void C(int key) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		Map<Integer, Integer> map = new HashMap<>(); // <number, count>

		for (int i = 1; i <= xLength; i++) {
			if (A[i][key] == 0)
				continue;
			map.compute(A[i][key], (num, count) -> count == null ? 1 : count + 1);
		}

		map.forEach((k, v) -> pq.add(new Pair(k, v)));

		int i = 1;
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			A[i++][key] = p.number;
			A[i++][key] = p.count;
		}

		xLength = Math.max(xLength, i);

		while (i <= 99) {
			A[i++][key] = 0;
			A[i++][key] = 0;
		}
	}

}

// reference: https://bcp0109.tistory.com/216