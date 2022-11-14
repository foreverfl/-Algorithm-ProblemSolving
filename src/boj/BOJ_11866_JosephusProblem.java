package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866_JosephusProblem {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		String res = "<" + makeSeq(queue, K) + ">";

		System.out.println(res.trim());
	}

	private static String makeSeq(Queue<Integer> queue, int K) {
		String res = "";

		while (!queue.isEmpty()) {

			for (int i = 0; i < K - 1; i++) {
				int now = queue.poll();
				queue.add(now);
			}
			res += Integer.toString(queue.poll()) + ", ";

		}

		res = res.substring(0, res.length() - 2);
		res = res.trim();

		return res;
	}

}
