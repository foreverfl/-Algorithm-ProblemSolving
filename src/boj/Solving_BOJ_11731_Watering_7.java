package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solving_BOJ_11731_Watering_7 {

	// 1. 지도 그리기
	// 2. 탐색

	private static int R, C;
	private static char[][] map;
	private static int[][] type1 = new int[][] { { 0, 0 }, { 0, 1 }, { 0, 2 } };
	private static int[][] type2 = new int[][] { { 0, 0 }, { 1, 0 }, { 2, 0 } };
	private static int[][] type3 = new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 } };
	private static int[][] type4 = new int[][] { { 0, 0 }, { 1, 0 }, { 1, 1 } };
	private static int[][] type5 = new int[][] { { 0, 0 }, { 0, 1 }, { 1, 1 } };
	private static int[][] type6 = new int[][] { { 0, 1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String... args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[6 * R - 1][6 * C - 1];

		for (int i = 0; i < 6 * R - 1; i++) {
			String str = br.readLine();
			for (int j = 0; j < 6 * C - 1; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		char blockChar = 'a';
		for (int i = 0; i < 6 * R - 1; i++) {
			for (int j = 0; j < 6 * C - 1; j++) {
				int x = i;
				int y = j;

				int type = chooseType(x, y);

				fillMap(blockChar, type, x, y);
				blockChar++;
				
				print();
				
				if (map[i][j] == '.') {

				} else if ((map[i][j] >= 'a' && map[i][j] >= 'z') || map[i][j] == '#') {
					continue;
				}

			}
		}

//		print();
	}

	private static void print() {
		for (int i = 0; i < 6 * R - 1; i++) {
			for (int j = 0; j < 6 * C - 1; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean isValid(int x, int y) {
		if (x >= 0 || x < 6 * R - 1 || y >= 0 || y < 6 * C - 1) {
			return true;
		}

		return false;
	}

	private static int chooseType(int x, int y) {
		int[] check = new int[7];
		int nx = 0;
		int ny = 0;
		for (int i = 0; i < 3; i++) {

			nx = x + type1[i][0];
			ny = y + type1[i][1];

			if (isValid(nx, ny) && map[nx][ny] == '.') {
				check[1]++;
			}

			nx = x + type2[i][0];
			ny = y + type2[i][1];

			if (isValid(nx, ny) && map[nx][ny] == '.') {
				check[2]++;
			}

			nx = x + type3[i][0];
			ny = y + type3[i][1];

			if (isValid(nx, ny) && map[nx][ny] == '.') {
				check[3]++;
			}
			nx = x + type4[i][0];
			ny = y + type4[i][1];

			if (isValid(nx, ny) && map[nx][ny] == '.') {
				check[4]++;
			}
			nx = x + type5[i][0];
			ny = y + type5[i][1];

			if (isValid(nx, ny) && map[nx][ny] == '.') {
				check[5]++;
			}
			nx = x + type6[i][0];
			ny = y + type6[i][1];

			if (isValid(nx, ny) && map[nx][ny] == '.') {
				check[6]++;
			}

		}

		for (int i = 1; i <= 6; i++) {
			if (check[i] == 3) {
				return i;
			}
		}

		return 0; // 불가능하다.
	}

	private static void fillMap(char blockChar, int type, int x, int y) {
		if (type == 1) {
			for (int i = 0; i < 3; i++) {
				map[x + type1[i][0]][y + type1[i][1]] = blockChar;
			}

		} else if (type == 2) {
			for (int i = 0; i < 3; i++) {
				map[x + type2[i][0]][y + type2[i][1]] = blockChar;
			}

		} else if (type == 3) {
			for (int i = 0; i < 3; i++) {
				map[x + type3[i][0]][y + type3[i][1]] = blockChar;
			}

		} else if (type == 4) {
			for (int i = 0; i < 3; i++) {
				map[x + type4[i][0]][y + type4[i][1]] = blockChar;
			}

		} else if (type == 5) {
			for (int i = 0; i < 3; i++) {
				map[x + type5[i][0]][y + type5[i][1]] = blockChar;
			}

		} else if (type == 6) {
			for (int i = 0; i < 3; i++) {
				map[x + type6[i][0]][y + type6[i][1]] = blockChar;
			}

		}
	}

}
