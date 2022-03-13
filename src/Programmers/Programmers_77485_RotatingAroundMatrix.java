package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_77485_RotatingAroundMatrix {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int rows = Integer.parseInt(st.nextToken());
		int columns = Integer.parseInt(st.nextToken());

		int cnt_query = Integer.parseInt(br.readLine());
		int[][] queries = new int[cnt_query][4];
		for (int i = 0; i < cnt_query; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				queries[i][j] = Integer.parseInt(st.nextToken());
			}
		}

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
			int start_y = queries[i][0] - 1;
			int start_x = queries[i][1] - 1;
			int end_y = queries[i][2] - 1;
			int end_x = queries[i][3] - 1;

			for (int j = start_x; j <= end_x; j++) {
				rotate.add(map[start_y][j]);
			}

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
