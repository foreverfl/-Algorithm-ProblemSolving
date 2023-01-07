package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_12851_HideAndSeek_2 {

	static int N, K;
	static int[] time = new int[100001];
	static int min_time = Integer.MAX_VALUE, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N == K) {
			System.out.println(0);
			System.out.println(1);
			return;
		}

		bfs(N);

		System.out.println(min_time);
		System.out.println(cnt);
	}

	public static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(num);
		time[num] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (min_time < time[now]) {
				return;
			}

			for (int i = 0; i < 3; i++) {
				int nxt = 0;

				if (i == 0)
					nxt = now + 1;
				else if (i == 1)
					nxt = now - 1;
				else if (i == 2)
					nxt = now * 2;

				if (isRange(nxt)) {
					if (nxt == K) {
						min_time = time[now];
						cnt++;
					}

					if (time[nxt] == 0 || time[nxt] == time[now] + 1) {
						queue.add(nxt);
						time[nxt] = time[now] + 1;
					}
				}
			}
		}
	}

	public static boolean isRange(int num) {
		if (num >= 0 && num <= 100000)
			return true;

		return false;
	}

}

// reference: https://bcp0109.tistory.com/154
