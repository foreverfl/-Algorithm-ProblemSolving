package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01963_PrimePath {

	static class Node {
		int num;
		int cnt;

		Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	static boolean[] prime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {

			// init
			prime = new boolean[9999 + 1];
			checkPrime();

			st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			int ans = bfs(A, B);

			if (ans == -1)
				sb.append("Impossible").append('\n');
			else
				sb.append(ans).append('\n');

		}

		System.out.print(sb.toString());
	}

	public static void checkPrime() {
		int N = 9999;

		// prime -> false
		prime[0] = prime[1] = true;

		for (int i = 2; i * i <= N; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= N; j += i)
					prime[j] = true;
			}
		}
	}

	public static int bfs(String A, String B) {
		Queue<Node> queue = new LinkedList<>();

		queue.offer(new Node(Integer.parseInt(A), 0));
		prime[Integer.parseInt(A)] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (Integer.toString(now.num).equals(B)) {
				return now.cnt;
			}

			for (int i = 0; i < 4; i++) {
				StringBuilder now_str = new StringBuilder(Integer.toString(now.num));
				String tmp = "";

				for (int j = 0; j <= 9; j++) {
					tmp = now_str.replace(i, i + 1, Integer.toString(j)).toString();

					if (!prime[Integer.parseInt(tmp)] && isRange(Integer.parseInt(tmp))) {
						prime[Integer.parseInt(tmp)] = true;
						queue.offer(new Node(Integer.parseInt(tmp), now.cnt + 1));
					}
				}
			}

		}

		return -1;
	}

	public static boolean isRange(int num) {
		if (num >= 1000 && num <= 9999)
			return true;

		return false;
	}

}
