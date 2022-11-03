package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_03163_FallingAnts {

	static class Ant implements Comparable<Ant> {
		int id, dist;

		Ant(int id, int pos) {
			this.id = id;
			this.dist = pos;
		}

		@Override
		public int compareTo(Ant o) {
			int res = this.dist - o.dist;
			if (this.dist == o.dist) {
				res = this.id - o.id;
			}
			return res;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			List<Ant> list = new ArrayList<>();
			Deque<Integer> id_list = new ArrayDeque<>();
			List<Integer> fall_list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());

				int dist = 0;
				if (a > 0) {
					dist = L - p;
				} else {
					dist = p;
				}
				Ant ant = new Ant(a, dist);

				list.add(ant);
				id_list.add(a);
			}

			Collections.sort(list);

			for (int i = 0; i < list.size(); i++) {
				int front = id_list.peekFirst();
				int back = id_list.peekLast();

				// If falling times are same
				if (i != list.size() - 1 && list.get(i).dist == list.get(i + 1).dist) {

					// The ant whose id is smaller falls first.
					if (front < back) {
						fall_list.add(front);
						fall_list.add(back);
					} else {
						fall_list.add(back);
						fall_list.add(front);
					}

					// clearing the deque and increasing i one time
					id_list.pollLast();
					id_list.pollFirst();
					i++;
				}

				// falling sequence is decided according to ant's id(direction)
				else if (list.get(i).id < 0) {
					fall_list.add(front);
					id_list.pollFirst();
				} else {
					fall_list.add(back);
					id_list.pollLast();	
				}
			}

			sb.append(fall_list.get(k - 1)).append('\n');

		}

		System.out.println(sb.toString());
	}
}

// reference: https://sexycoder.tistory.com/100