package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11931_ArrangingNumbers_4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		while (N-- > 0) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append('\n');
		}

		System.out.println(sb.toString());

	}

}
