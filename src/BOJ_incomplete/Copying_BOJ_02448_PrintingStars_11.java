package BOJ_incomplete;

import java.util.Scanner;

public class Copying_BOJ_02448_PrintingStars_11 {
	private static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		map = new char[n][2 * n - 1];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < 2 * n - 1; j++)
				map[i][j] = ' ';

		drawStar(0, n - 1, n);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n - 1; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
	}

	private static void drawStar(int x, int y, int n) {
		if (n == 3) {
			map[x][y] = '*';
			map[x + 1][y - 1] = map[x + 1][y + 1] = '*';
			map[x + 2][y - 2] = map[x + 2][y - 1] = map[x + 2][y] = map[x + 2][y + 1] = map[x + 2][y + 2] = '*';
			return;
		}

		drawStar(x, y, n / 2);
		drawStar(x + n / 2, y - n / 2, n / 2);
		drawStar(x + n / 2, y + n / 2, n / 2);
	}
}
