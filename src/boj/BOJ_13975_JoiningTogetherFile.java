package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13975_JoiningTogetherFile {

	private static PriorityQueue<Long> pq = new PriorityQueue<>();
	private static List<Long> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			
			
			int K = Integer.parseInt(br.readLine());
		
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}

			while (pq.size() != 1) {
				long A = pq.poll();
				long B = pq.poll();
				long tmp = A + B;
				pq.add(tmp);
				list.add(tmp);
			}

			long answer = 0;
			for (int i = 0; i < list.size(); i++) {
				answer += list.get(i);
			}

			sb.append(answer).append('\n');
			
			pq.clear();
			list.clear();
		}			

		System.out.println(sb.toString());

	}

}
