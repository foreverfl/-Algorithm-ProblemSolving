package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_12018_YonseiTOTO {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			List<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int repeat = P;
			while (repeat-- > 0) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			Collections.sort(list);

			int needed_mileage = 0;
			int cantApply = P - L;
			if (cantApply >= 0) {
				while (cantApply-- > 0) {
					list.remove(0);
				}
				needed_mileage = list.get(0);
			} else {
				needed_mileage = 1;
			}

			pq.add(needed_mileage);

		}

		int ans = 0;
		while (true) {

			m -= pq.poll();

			if (m < 0)
				break;

			ans++;
			
			if(pq.isEmpty())
				break;
		}

		System.out.println(ans);
	}

}
