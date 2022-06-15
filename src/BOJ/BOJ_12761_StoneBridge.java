package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12761_StoneBridge {

	static class Pos {
		int now;
		int cnt;

		Pos(int now, int cnt) {
			this.now = now;
			this.cnt = cnt;
		}
	}

	static boolean visited[] = new boolean[100001];
	static int A, B, N, M;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		bfs(N, M);

		System.out.print(ans);
	}

	public static void bfs(int now, int target) {
		Queue<Pos> queue = new LinkedList<>();

		queue.offer(new Pos(now, 0));
		visited[now] = true;

		while (!queue.isEmpty()) {
			Pos current = queue.poll();
			if (current.now == target) {
				ans = current.cnt;
				return;
			}

			int[] dir = new int[8];
			dir[0] = current.now * A;
			dir[1] = current.now * B;
			dir[2] = current.now + A;
			dir[3] = current.now + B;
			dir[4] = current.now - A;
			dir[5] = current.now - B;
			dir[6] = current.now + 1;
			dir[7] = current.now - 1;

			for (int i = 0; i < 8; i++) {
				if (dir[i] < 0 || dir[i] >= 100001)
					continue;

				if (visited[dir[i]])
					continue;

				visited[dir[i]] = true;
				queue.offer(new Pos(dir[i], current.cnt + 1));

			}
		}
	}

}
