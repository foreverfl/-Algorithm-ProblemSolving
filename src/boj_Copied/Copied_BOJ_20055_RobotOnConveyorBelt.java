package boj_Copied;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Copied_BOJ_20055_RobotOnConveyorBelt {

	private static int N, K;
	private static int[] belt;
	private static boolean[] robot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2 * N];
		robot = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < belt.length; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		bw.write(simulation(0) + "\n");

		br.close();
		bw.flush();
		bw.close();
	}

	private static int simulation(int cnt) {
		while (isOK()) {

			// 1. 벨트 한 칸 회전
			int temp = belt[belt.length - 1];
			for (int i = belt.length - 1; i > 0; i--) {
				belt[i] = belt[i - 1];
			}
			belt[0] = temp;

			// 로봇도 벨트와 같이 회전
			for (int i = robot.length - 1; i > 0; i--) {
				robot[i] = robot[i - 1];
			}
			robot[0] = false;

			// 2. 로봇 이동가능하면 이동
			robot[N - 1] = false;
			for (int i = N - 1; i > 0; i--) {
				if (robot[i - 1] && !robot[i] && belt[i] >= 1) {
					robot[i] = true;
					robot[i - 1] = false;
					belt[i]--;
				}
			}

			// 3. 올라가는 위치에 로봇 올리기
			if (belt[0] > 0) {
				robot[0] = true;
				belt[0]--;
			}

			cnt++;
		}

		return cnt;
	}

	private static boolean isOK() {
		int cnt = 0;

		for (int i = 0; i < belt.length; i++) {
			if (belt[i] == 0) {
				cnt++;
			}
			if (cnt >= K) {
				return false;
			}
		}
		return true;
	}

}

// reference: https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-20055-%EC%BB%A8%EB%B2%A0%EC%9D%B4%EC%96%B4-%EB%B2%A8%ED%8A%B8-%EC%9C%84%EC%9D%98-%EB%A1%9C%EB%B4%87-java
