package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Copied_BOJ_12764_JunhaGoingComputerRoom {

	static class Time implements Comparable<Time> {
		int s, e; // start, end

		Time(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Time o) {
			return this.s - o.s;
		}

		@Override
		public String toString() {
			return "Time [s=" + s + ", e=" + e + "]";
		}
		
		
	}

	static class computer implements Comparable<computer> {
		int e, idx;

		computer(int e, int idx) {
			this.e = e;
			this.idx = idx;
		}

		@Override
		public int compareTo(computer o) {
			return Integer.compare(this.e, o.e);
		}

		@Override
		public String toString() {
			return "computer [e=" + e + ", idx=" + idx + "]";
		}
		
		
	}

	static PriorityQueue<Time> times = new PriorityQueue<>();
	static PriorityQueue<computer> computers = new PriorityQueue<>();
	static PriorityQueue<Integer> nextCom = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			times.offer(new Time(p, q));
		}

		int[] comIndex = new int[100001];
		int comCount = 0;

		for (int i = 0; i < N; i++) {
			while (!computers.isEmpty() && times.peek().s > computers.peek().e) {
				nextCom.offer(computers.poll().idx);
			}

			if (nextCom.isEmpty()) {
				computers.offer(new computer(times.poll().e, comCount));
				comIndex[comCount]++;
				comCount++;
			} else {
				computers.offer(new computer(times.poll().e, nextCom.peek()));
				comIndex[nextCom.poll()]++;
			}
		}

		sb.append(comCount).append('\n');

		for (int i = 0; i < comCount; i++) {
			sb.append(comIndex[i] + " ");
		}

		System.out.println(sb.toString());

	}

}

// reference: https://moz1e.tistory.com/520
