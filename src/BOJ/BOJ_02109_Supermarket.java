package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_02109_Supermarket {

	static class Lecture implements Comparable<Lecture> {
		int day;
		int pay;
		

		Lecture(int day, int pay) {
			this.day = day;
			this.pay = pay;
			
		}

		@Override
		public int compareTo(Lecture o) {
			if (o.day == this.day)
				return o.pay - this.pay;

			return this.day - o.day;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Lecture[] lectures = new Lecture[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());

			lectures[i] = new Lecture(day, pay);
		}
		
		Arrays.sort(lectures);

		PriorityQueue<Integer> pq =new PriorityQueue<>();
		
		for (Lecture lecture : lectures) {
			if (pq.size() < lecture.day) {
				pq.offer(lecture.pay);
			} else if (pq.size() == lecture.day) {
				int tmp = pq.peek();
				if (tmp < lecture.pay) {
					pq.poll();
					pq.offer(lecture.pay);
				}
			}
		}
		
		long ans = 0;
		while (!pq.isEmpty()) {
			ans += pq.poll();
		}

		System.out.println(ans);
	}

}
