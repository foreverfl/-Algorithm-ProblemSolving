package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solving_BOJ_09869_MilkScheduling {

	private static class Cow implements Comparable<Cow> {
		int milk;
		int time;

		public Cow(int milk, int time) {
			this.milk = milk;
			this.time = time;
		}

		@Override
		public int compareTo(Cow o) {
			if (this.time == o.time)
				return o.milk - this.milk;

			return this.time - o.time;
		}

		@Override
		public String toString() {
			return "Cow [milk=" + milk + ", time=" + time + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Cow> pq = new PriorityQueue<>();
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int milk = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			pq.offer(new Cow(milk, time));
		}

		Cow first = pq.poll();
		int nowTime = first.time;
		int ans = first.milk;
		while (!pq.isEmpty()) {
			Cow now = pq.poll();

			if (now.time <= nowTime) {
				continue;
			}

			ans += now.milk;
			nowTime += now.time;
		}

		System.out.println(ans);
	}

}
