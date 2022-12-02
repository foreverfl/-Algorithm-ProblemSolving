package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_14939_TurningOff {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] map = new char[10][10];
		for (int i = 0; i < 10; i++) {
			map[i] = br.readLine().toCharArray();
		}

		char[][] tmp = new char[10][10];

		for (int c = 0; c < (1 << 10); c++) { // 2의 10승
			deepCopy(map, tmp);
			
			int cnt = 0;

			cnt = simulation(tmp, c, cnt);

			if (isAllOff(tmp)) {
				answer = Math.min(answer, cnt);
			}
		}

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	private static boolean isAllOff(char[][] tmp) { // 마지막 줄을 체크한다.
		boolean flag = true;
		for (int x = 0; x < 10; x++) {
			if (tmp[9][x] == 'O') {
				flag = false;
				break;
			}
		}
		return flag;
	}

	private static int simulation(char[][] tmp, int c, int cnt) {
		for (int x = 0; x < 10; x++) { // 첫 번째 줄을 체크한다.
			if ((c & (1 << x)) != 0) { // x가 눌려있지 않다면
				lightSwitch(tmp, x, 0); // x를 누른다.
				cnt++;
			}
		}

		for (int y = 1; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				if (tmp[y - 1][x] == 'O') { // If the upper line's light is on. 
					lightSwitch(tmp, x, y);
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void lightSwitch(char[][] map, int x, int y) {
		map[y][x] = switchOnOff(map[y][x]); // center
		for (int d = 0; d < 4; d++) { // all sides
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= 10 || ny >= 10)
				continue;

			map[ny][nx] = switchOnOff(map[ny][nx]);
		}
	}

	private static char switchOnOff(char status) {
		if (status == '#')
			return 'O';
		else
			return '#';
	}

	private static void deepCopy(char[][] src, char[][] copy) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				copy[i][j] = src[i][j];
			}
		}
	}
}

// reference: https://loosie.tistory.com/756