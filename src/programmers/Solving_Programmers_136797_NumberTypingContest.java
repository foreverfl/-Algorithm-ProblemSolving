package programmers;

import java.awt.Point;

public class Solving_Programmers_136797_NumberTypingContest {

	public static void main(String[] args) {
		System.out.println(solution("1756"));
		System.out.println(solution("5123"));
	}

	// 북쪽을 거쳐서 시계방향으로 탐색한다.
	private static int[] dx = { -1, -1, +0, +1, +1, +1, +0, -1 };
	private static int[] dy = { +0, +1, +1, +1, +0, -1, -1, -1 };
	private static char[][] keyboard = new char[][] { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' },
			{ '*', '0', '#' } };
	private static boolean[][] visited;
	// x, y 좌표가 반대로 되어있다.
	private static Point left = new Point(1, 0);
	private static Point right = new Point(1, 2);
	private static int tmp_weight, left_tmp_weight, right_tmp_weight;
	private static Point tmp_point, left_tmp_point, right_tmp_point;

	public static int solution(String numbers) {

		int ans = 0;
		for (int i = 0; i < numbers.length(); i++) {
			char nxt = numbers.charAt(i);

			// 원래 left/right의 위치일 경우
			if (keyboard[left.x][left.y] == nxt) {
				ans++;
			} else if (keyboard[right.x][right.y] == nxt) {
				ans++;
			}

			// 그렇지 않을 경우
			else {
				// 왼손
				tmp_weight = Integer.MAX_VALUE;
				visited = new boolean[4][3];
				dfs(left, nxt, 0);
				left_tmp_weight = tmp_weight;
				left_tmp_point = tmp_point;

				// 오른손
				tmp_weight = Integer.MAX_VALUE;
				visited = new boolean[4][3];
				dfs(right, nxt, 0);
				right_tmp_weight = tmp_weight;
				right_tmp_point = tmp_point;

				// 적게 움직인 손을 움직인다.
				if (left_tmp_weight >= right_tmp_weight) {
					ans += right_tmp_weight;
					right = new Point(right_tmp_point.x, right_tmp_point.y);
				} else {
					ans += left_tmp_weight;
					left = new Point(left_tmp_point.x, left_tmp_point.y);
				}
			}

		}

		return ans;
	}

	private static void dfs(Point point, char nxt, int weight) {
		if (keyboard[point.x][point.y] == nxt) {
			tmp_weight = Math.min(tmp_weight, weight);
			tmp_point = new Point(point.x, point.y);

		}

		for (int i = 0; i < 8; i++) {
			int nx = point.x + dx[i];
			int ny = point.y + dy[i];

			if (!isValid(nx, ny))
				continue;

			if (visited[nx][ny])
				continue;

			// 상하좌우
			if (i == 0 || i == 2 || i == 4 || i == 6) {
				visited[nx][ny] = true;
				dfs(new Point(nx, ny), nxt, weight + 2);
			}

			// 대각선
			else {
				visited[nx][ny] = true;
				dfs(new Point(nx, ny), nxt, weight + 3);
			}

		}

	}

	private static boolean isValid(int x, int y) {
		if (x < 0 || y < 0 || x >= 3 || y >= 2)
			return false;

		return true;
	}

}
