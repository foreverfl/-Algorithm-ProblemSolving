package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16212_PassionateSorting {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (N-- > 0)
			pq.add(Integer.parseInt(st.nextToken()));

		while (!pq.isEmpty())
			sb.append(pq.poll() + " ");

		System.out.println(sb.toString());
	}

}
