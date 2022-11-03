package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Copied_BOJ_01021_RotatingQueue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		LinkedList<Integer> deque = new LinkedList<Integer>();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			deque.offer(i);
		}

		int ans = 0;
		st = new StringTokenizer(br.readLine());
		while (M-- > 0) {

			int target_idx = deque.indexOf(Integer.parseInt(st.nextToken()));
			int half_idx;

			if (deque.size() % 2 == 0) {
				half_idx = deque.size() / 2 - 1;
			} else {
				half_idx = deque.size() / 2;
			}

			if (target_idx <= half_idx) {
				for (int j = 0; j < target_idx; j++) {
					int tmp = deque.pollFirst();
					deque.offerLast(tmp);
					ans++;
				}
			} else {
				for (int j = 0; j < deque.size() - target_idx; j++) {
					int tmp = deque.pollLast();
					deque.offerFirst(tmp);
					ans++;
				}

			}

			deque.pollFirst();
		}

		System.out.println(ans);

	}
}

// reference: https://www.acmicpc.net/problem/1021