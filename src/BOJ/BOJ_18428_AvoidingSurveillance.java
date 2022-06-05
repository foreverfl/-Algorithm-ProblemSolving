package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18428_AvoidingSurveillance {

	static char[][] original;
	static boolean[][] visited;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		original = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				original[i][j] = st.nextToken().charAt(0);
			}
		}

		backTracking(0);

		System.out.println("NO");

	}

	public static void backTracking(int depth) {
		if (depth == 3) {
			char[][] copied = new char[N][N];
			for (int i = 0; i < N; i++) {
				copied[i] = Arrays.copyOf(original[i], N);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) {
						copied[i][j] = 'O';
					}
				}
			}

			if (surveillance(copied)) {
				System.out.println("YES");
				System.exit(0);
			}

			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (original[i][j] == 'X') {
					if (!visited[i][j]) {
						visited[i][j] = true;
						backTracking(depth + 1);
						visited[i][j] = false;
					}
				}
			}
		}

	}

	public static boolean surveillance(char[][] map) {

		int x, y;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'T') {
					x = i;
					y = j;
					while (x-- > 0) {
						if (map[x][y] == 'S')
							return false;
						else if (map[x][y] == 'O')
							break;
					}

					x = i;
					y = j;
					while (x++ < N - 1) {
						if (map[x][y] == 'S')
							return false;

						else if (map[x][y] == 'O')
							break;
					}

					x = i;
					y = j;
					while (y-- > 0) {
						if (map[x][y] == 'S')
							return false;

						else if (map[x][y] == 'O')
							break;
					}

					x = i;
					y = j;
					while (y++ < N - 1) {
						if (map[x][y] == 'S')
							return false;

						else if (map[x][y] == 'O')
							break;
					}
				}
			}
		}

		return true;

	}

}
