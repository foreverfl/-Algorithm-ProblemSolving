package BOJ_incomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copying_BOJ_02638_Cheese {
	static int n, m, count, answer;
	static int[][] board; // ��ü ������
	static boolean[][] visited; // dfs �湮 üũ
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		count = 0;
		answer = 0;

		board = new int[n][m];
		visited = new boolean[n][m];

		// ġ�� 1
		// �ٱ� ���� 2
		// ���� ���� 0
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int value = Integer.parseInt(st.nextToken());
				board[i][j] = value;

				if (value == 1)
					count++;
			}
		}

		checkExternalAir(0, 0);

		while (count != 0) {
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (board[i][j] == 1 && !visited[i][j])
						dfs(i, j);
				}
			}

			visited = new boolean[n][m];
			checkExternalAir(0, 0);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					board[i][j] = board[i][j] == 3 ? 2 : board[i][j];
				}
			}

			answer++;
		}

		System.out.println(answer);
	}

	// �ܺο� ������ ���� '2'�� ǥ��
	static void checkExternalAir(int x, int y) {
		visited[x][y] = true;
		board[x][y] = 2;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;
			if (visited[nx][ny] || board[nx][ny] == 1)
				continue;

			board[nx][ny] = 2;
			checkExternalAir(nx, ny);
		}
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;

		if (board[x][y] == 1 && isMelt(x, y)) {
			--count;
			board[x][y] = 3; // ���� ġ��� 3���� �ٲ��ش� (0���� �ٲٸ� ���� ��Ҵ��� ���� �Ұ�)
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;
			if (visited[nx][ny] || board[nx][ny] == 0)
				continue;

			dfs(nx, ny);
		}
	}

	static boolean isMelt(int x, int y) {
		int air = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;
			if (board[nx][ny] == 2)
				++air;
		}

		return air >= 2;
	}
}