package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_20044_ProjectTeams {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		while (!list.isEmpty()) {
			int tmp = list.get(list.size() - 1) + list.get(0);
			list.remove(list.size() - 1);
			list.remove(0);
			pq.add(tmp);
		}

		System.out.println(pq.poll());
	}

}
