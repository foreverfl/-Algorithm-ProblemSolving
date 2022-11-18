package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13567_Robot {

	private static class Robot {
		int x;
		int y;
		int dir = 1;

		public Robot() {

		}
	}

	private static int M, n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		Robot robot = new Robot();
		robot.x = M - 1;
		robot.y = 0;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int num = Integer.parseInt(st.nextToken());

			int x = robot.x;
			int y = robot.y;
			int dir = robot.dir;

			if (command.equals("MOVE")) {
				if (dir == 0) {
					x -= num;
				} else if (dir == 1) {
					y += num;
				} else if (dir == 2) {
					x += num;
				} else if (dir == 3) {
					y -= num;
				}
			} else {
				// 왼쪽으로 회전
				if (num == 0) {
					dir = (dir + 3) % 4;
				}

				// 오른쪽으로 회전
				else if (num == 1) {
					dir = (dir + 1) % 4;
				}

			}

			if (!isValid(x, y)) {
				System.out.println(-1);
				System.exit(0);
			}

			robot.x = x;
			robot.y = y;
			robot.dir = dir;

//			System.out.println("[" + i + "] " + robot.y + " " + ((M - 1) - robot.x) + " / " + robot.dir);

		}

		System.out.println(robot.y + " " + ((M - 1) - robot.x));

	}

	private static boolean isValid(int x, int y) {
		if (x < 0 || x >= M || y < 0 || y >= M) {
			return false;
		}

		return true;
	}

}
