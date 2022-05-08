import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class tmp {

	static class Point implements Comparable<Point> {
		int y, x, time;

		public Point(int yy, int xx, int t) {
			y = yy;
			x = xx;
			time = t;
		}

		@Override
		public int compareTo(Point o) {
			return time - o.time;
		}
	}

	static final int INF = 1000000000;
	static int[][] map = new int[26][26], dist[][] = new int[26][26][26][26];
	static int[] Y = { -1, 1, 0, 0 }, X = { 0, 0, -1, 1 };
	static int r, c, t, d;

	static void Dijkstra(int yy, int xx) {

		Queue<Point> Q = new PriorityQueue<>();
		dist[yy][xx][yy][xx] = 0;
		Q.add(new Point(yy, xx, 0));

		while (!Q.isEmpty()) {
			Point p = Q.poll();

			int y = p.y;
			int x = p.x;
			int time = p.time;

			if (dist[y][x][yy][xx] < time)
				continue;

			for (int a = 0; a < 4; a++) {
				int ny = y + Y[a];
				int nx = x + X[a];
				int nTime;

				if (ny < 1 || nx < 1 || ny > r || nx > c)
					continue;
				if (Math.abs(map[y][x] - map[ny][nx]) > t)
					continue;

				if (map[ny][nx] <= map[y][x])
					nTime = time + 1;
				else
					nTime = (int) Math.pow((map[ny][nx] - map[y][x]), 2) + time;

				if (dist[ny][nx][yy][xx] > nTime && nTime <= d) {
					dist[ny][nx][yy][xx] = nTime;
					Q.add(new Point(ny, nx, nTime));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= r; i++)
			for (int j = 1; j <= c; j++)
				for (int k = 1; k <= r; k++)
					for (int z = 1; z <= c; z++)
						dist[i][j][k][z] = INF;

		for (int i = 1; i <= r; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 1; j <= c; j++) {
				char ch = str[j - 1];

				if (ch >= 'A' && ch <= 'Z')
					map[i][j] = ch - 65;
				else if (ch >= 'a' && ch <= 'z')
					map[i][j] = ch - 71;

			}
		}

		for (int i = 1; i <= r; i++)
			for (int j = 1; j <= c; j++)
				Dijkstra(i, j);

		int max = 0;

		for (int i = 1; i <= r; i++)
			for (int j = 1; j <= c; j++)
				if (dist[i][j][1][1] + dist[1][1][i][j] <= d)
					max = Math.max(max, map[i][j]);

		System.out.println(max);

	}
}
