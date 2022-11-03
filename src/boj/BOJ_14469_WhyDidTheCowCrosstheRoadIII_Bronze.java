package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14469_WhyDidTheCowCrosstheRoadIII_Bronze {

	static class Cow implements Comparable<Cow> {
		int come;
		int time;

		Cow(int come, int time) {
			this.come = come;
			this.time = time;
		}

		@Override
		public int compareTo(Cow o) {
			if (this.come == o.come)
				return this.time - o.time;
			return this.come - o.come;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Cow[] arr = new Cow[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int come = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			arr[i] = new Cow(come, time);
		}

		Arrays.sort(arr);

		int now = 0;
		for (int i = 0; i < N; i++) {
			int come = arr[i].come;
			int time = arr[i].time;

			if (come >= now)
				now = come;

			now += time;

		}

		System.out.println(now);
	}

}
