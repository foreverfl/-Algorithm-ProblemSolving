package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_02457_GardenOfPrincess {

	static class Flower implements Comparable<Flower> {
		int start;
		int end;

		Flower(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Flower o) {
			if (this.start == o.start)
				return o.end - this.end;
			return this.start - o.start;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Flower[] flowers = new Flower[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int startMonth = Integer.valueOf(st.nextToken());
			int startDay = Integer.valueOf(st.nextToken());
			int endMonth = Integer.valueOf(st.nextToken());
			int endDay = Integer.valueOf(st.nextToken());

			int start = startMonth * 100 + startDay;
			int end = endMonth * 100 + endDay;
			flowers[i] = new Flower(start, end);
		}

		Arrays.parallelSort(flowers);

		int endDay = 1201;
		int start = 301;
		int count = 0;
		int max = 0;
		int index = 0;

		while (start < endDay) {
			boolean isFound = false;

			for (int i = index; i < n; i++) {
				if (flowers[i].start > start)
					break;

				if (max < flowers[i].end) {
					isFound = true;
					max = flowers[i].end;
					index = i + 1;
				}
			}

			if (isFound) {
				start = max;
				count++;
			} else {
				break;
			}
		}

		if (max < endDay) {
			System.out.println(0);
		} else {
			System.out.println(count);
		}
	}
}

// reference: https://maivve.tistory.com/324
