package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_01981_MovingInTheArray {

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map;
	static int[] dx = { -1, 1, 0, 0, };
	static int[] dy = { 0, 0, -1, 1 };
	static int n;
	static int ans, maxNum, minNum = 200;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxNum = Math.max(maxNum, map[i][j]);
				minNum = Math.min(minNum, map[i][j]);
			}
		}

		binarySearch(0, maxNum - minNum);

		System.out.print(ans);

	}

	public static void binarySearch(int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;

			if (whetherItCanBeReached(mid)) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
	}

	public static boolean whetherItCanBeReached(int diff) {
		// trying all section whose diff is 's - e'
		for (int i = minNum; i + diff <= maxNum; i++) {
			int s = i;
			int e = s + diff;

			// checking the starting point
			if (s > map[0][0] || map[0][0] > e) {
				continue;
			}

			boolean[][] visited = new boolean[n][n];

			Queue<Node> queue = new ArrayDeque<>();
			queue.offer(new Node(0, 0));
			visited[0][0] = true;

			while (!queue.isEmpty()) {
				Node cur = queue.poll();

				if (cur.x == n - 1 && cur.y == n - 1) {
					return true;
				}

				for (int j = 0; j < 4; j++) {
					int nx = cur.x + dx[j];
					int ny = cur.y + dy[j];

					if (inRange(nx, ny) && !visited[nx][ny] && s <= map[nx][ny] && map[nx][ny] <= e) {
						queue.offer(new Node(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}

		return false;
	}

	public static boolean inRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < n) {
			return true;
		}
		return false;
	}

}

// reference: https://gre-eny.tistory.com/304