package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Copied_BOJ_13913_HideAndSeek_4 {

	static int N, K;
	static int[] time = new int[100001];
	static int[] path = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs(N);

		Stack<Integer> stack = new Stack<>();
		stack.push(K);
		int index = K;

		while (index != N) {
			stack.push(path[index]);
			index = path[index];
		}

		sb.append(time[K] - 1).append('\n');
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}

		System.out.println(sb.toString());
	}

	public static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(num);
		time[num] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now == K) {
				return;
			}

			for (int i = 0; i < 3; i++) {
				int next;

				if (i == 0)
					next = now + 1;
				else if (i == 1)
					next = now - 1;
				else
					next = now * 2;

				if (isRange(next) && time[next] == 0) {
					queue.offer(next);
					time[next] = time[now] + 1;
					path[next] = now;
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

// reference: https://bcp0109.tistory.com/156
