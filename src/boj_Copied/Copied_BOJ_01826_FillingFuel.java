package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_01826_FillingFuel {

	static class Station implements Comparable<Station> {
		int distance;
		int fuel;

		Station(int distance, int fuel) {
			this.distance = distance;
			this.fuel = fuel;
		}

		@Override
		public int compareTo(Station o) {
			return this.distance - o.distance;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Station> stations = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			stations.add(new Station(a, b));
		}

		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> fuels = new PriorityQueue<>(Collections.reverseOrder());

		int ans = 0;

		while (P < L) { // The 'P(used fuel / total distance)' increases continuously.
			while (!stations.isEmpty() && stations.peek().distance <= P) {
				fuels.add(stations.poll().fuel);
			}

			if (fuels.isEmpty()) {
				System.out.println(-1);
				return;
			}

			ans++;
			P += fuels.poll();
		}

		System.out.println(ans);
	}

}

// reference: https://dlee0129.tistory.com/211
