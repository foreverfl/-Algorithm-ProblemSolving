package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Copied_BOJ_01446_Shortcut {

	static class Road implements Comparable<Road> {
		int start, end, weight;

		Road(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Road o) {
			if (this.start == o.start)
				return this.end - o.end;
			return this.start - o.start;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		List<Road> list = new ArrayList<>();

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// being prohibited from going backwards
			if (end > D)
				continue;
			// no shortcut
			if (end - start <= weight)
				continue;
			list.add(new Road(start, end, weight));
		}

		Collections.sort(list);

		int idx = 0, move = 0;
		int[] dist = new int[10001];
		Arrays.fill(dist, 10001);
		dist[0] = 0;

		// Dijkstra
		while (move < D) {
			if (idx < list.size()) {
				Road now = list.get(idx);
				if (move == now.start) {
					dist[now.end] = Math.min(dist[move] + now.weight, dist[now.end]);
					idx++;
				} else {
					dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
					move++;
				}
			} else {
				dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
				move++;
			}
		}
		System.out.println(dist[D]);
	}

}

// reference: https://coder-in-war.tistory.com/entry/BOJ-JAVA1446-%EC%A7%80%EB%A6%84%EA%B8%B8