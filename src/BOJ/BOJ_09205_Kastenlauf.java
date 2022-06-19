package BOJ;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_09205_Kastenlauf {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int total = n + 2;
			Point[] arr = new Point[total];

			// home
			st = new StringTokenizer(br.readLine());
			arr[0] = new Point();
			arr[0].x = Integer.parseInt(st.nextToken());
			arr[0].y = Integer.parseInt(st.nextToken());

			// convenient stores
			for (int i = 1; i < total - 1; i++) {
				arr[i] = new Point();
				st = new StringTokenizer(br.readLine());
				arr[i].x = Integer.parseInt(st.nextToken());
				arr[i].y = Integer.parseInt(st.nextToken());
			}

			// target
			st = new StringTokenizer(br.readLine());
			arr[total - 1] = new Point();
			arr[total - 1].x = Integer.parseInt(st.nextToken());
			arr[total - 1].y = Integer.parseInt(st.nextToken());

			String ans = bfs(arr, total);
			sb.append(ans).append('\n');
		}

		System.out.print(sb.toString());
	}

	public static String bfs(Point[] arr, int num) {
		boolean[] visited = new boolean[num];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(arr[0]);
		visited[0] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			if (now == arr[num - 1]) {
				return "happy";
			}

			for (int i = 1; i < num; i++) {
				if (isPossible(now, arr[i]) && !visited[i]) {
					queue.offer(arr[i]);
					visited[i] = true;
				}
			}
		}

		return "sad";
	}

	public static boolean isPossible(Point A, Point B) {
		int dist = Math.abs(A.x - B.x) + Math.abs(A.y - B.y);

		if (dist <= 1000)
			return true;

		return false;
	}

}
