package programmers_Copied;

import java.util.ArrayList;

public class Copied_Programmers_86052_CycleOfLightPath {

	public static void main(String[] args) {
		int[] arr;
		arr = solution(new String[] { "SL", "LR" });
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		arr = solution(new String[] { "S" });
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		arr = solution(new String[] { "R", "R" });
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	private static int R, C;
	// 남서북동
	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, -1, 0, 1 };
	private static boolean[][][] isVisited;

	public static int[] solution(String[] grid) {
		ArrayList<Integer> answer = new ArrayList<Integer>();

		R = grid.length;
		C = grid[0].length();

		isVisited = new boolean[R][C][4];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				for (int d = 0; d < 4; d++) {
					if (!isVisited[i][j][d])
						answer.add(light(grid, i, j, d));
				}
			}
		}

		return answer.stream().sorted().mapToInt(i -> i).toArray();
	}

	private static int light(String[] grid, int r, int c, int d) {
		int cnt = 0; // 이동거리

		while (true) {
			if (isVisited[r][c][d])
				break;

			cnt++;
			isVisited[r][c][d] = true;

			if (grid[r].charAt(c) == 'L')
				d = d == 0 ? 3 : d - 1; // 좌회전
			else if (grid[r].charAt(c) == 'R')
				d = d == 3 ? 0 : d + 1; // 우회전

			r = (r + dr[d] + R) % R;
			c = (c + dc[d] + C) % C;
		}

		return cnt;
	}

}
