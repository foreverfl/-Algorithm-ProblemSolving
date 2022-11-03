package boj_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Copied_BOJ_16946_MovingThroughWall {

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map, group;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int n;
	static int m;
	static Map<Integer, Integer> groupSize;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		group = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int groupCnt = 1; // the first value
		groupSize = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0 && group[i][j] == 0) {
					groupSize.put(groupCnt, bfs(i, j, groupCnt));
					groupCnt++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (group[i][j] == 0) {
					sb.append(count(i, j) + "");
					continue;
				}
				sb.append(0 + "");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	static int count(int x, int y) {
		int cnt = 1;

		if (map[x][y] == 0)
			return 0;
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m || group[nx][ny] == 0)
				continue;

			set.add(group[nx][ny]); // preventing to be duplicate

		}
		for (int size : set) {
			cnt += groupSize.get(size);
		}

		return cnt % 10;
	}

	// making the 'group' array by counting the '0' by each group
	static int bfs(int x, int y, int groupCnt) {
		int cnt = 1;

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		group[x][y] = groupCnt;

		while (!queue.isEmpty()) {
			Point point = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				if (group[nx][ny] == 0 && map[nx][ny] == 0) {
					group[nx][ny] = groupCnt;
					cnt++;
					queue.add(new Point(nx, ny));
				}
			}
		}
		return cnt;

	}

}

// reference: https://technote-mezza.tistory.com/59
