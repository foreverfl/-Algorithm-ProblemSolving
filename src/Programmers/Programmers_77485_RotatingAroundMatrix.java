package Programmers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Programmers_77485_RotatingAroundMatrix {

	public static void main(String[] args) throws IOException {
		int rows = 6, columns = 6;
		int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };

		int[] ans = solution(rows, columns, queries);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}

	}

	public static int[] solution(int rows, int columns, int[][] queries) {
		int[][] map = new int[rows][columns];
		int idx = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = idx;
				idx++;
			}
		}

		int tmp = queries.length;
		int[] answer = new int[tmp];
		for (int i = 0; i < tmp; i++) {
			// extraction
			List<Integer> rotate = new ArrayList<>();
			int start_y = queries[i][0] - 1; // matching with index
			int start_x = queries[i][1] - 1;
			int end_y = queries[i][2] - 1;
			int end_x = queries[i][3] - 1;

			// {2, 2} {5, 4}
			// {1, 1} {4, 3}
			// {y, x} {y, x}

			for (int j = start_x; j <= end_x; j++) {
				rotate.add(map[start_y][j]);
			}
			
			// map[y][x]

			for (int j = start_y + 1; j <= end_y; j++) {
				rotate.add(map[j][end_x]);
			}

			for (int j = end_x - 1; j >= start_x; j--) {
				rotate.add(map[end_y][j]);
			}

			for (int j = end_y - 1; j > start_y; j--) {
				rotate.add(map[j][start_x]);
			}

			// rotation
			int change = rotate.get(rotate.size() - 1);
			rotate.remove(rotate.size() - 1);
			rotate.add(0, change);

			// finding the minimum value
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < rotate.size(); j++) {
				min = Math.min(min, rotate.get(j));
			}
			answer[i] = min;

			// input
			int idx_input = 0;
			for (int j = start_x; j <= end_x; j++) {
				map[start_y][j] = rotate.get(idx_input);
				idx_input++;
			}

			for (int j = start_y + 1; j <= end_y; j++) {
				map[j][end_x] = rotate.get(idx_input);
				idx_input++;
			}

			for (int j = end_x - 1; j >= start_x; j--) {
				map[end_y][j] = rotate.get(idx_input);
				idx_input++;
			}

			for (int j = end_y - 1; j > start_y; j--) {
				map[j][start_x] = rotate.get(idx_input);
				idx_input++;
			}

		}

		return answer;
	}

}
