package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_15903_PlayOfCombiningCards {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}

		for (int i = 0; i < m; i++) {
			long x = pq.poll();
			long y = pq.poll();
			long tmp = x + y;
			pq.add(tmp);
			pq.add(tmp);
		}

		long sum = 0;
		Iterator<Long> iterator = pq.iterator();
		while (iterator.hasNext()) {
			sum += iterator.next();
		}

		System.out.println(sum);
	}

}
