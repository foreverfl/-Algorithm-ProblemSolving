package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_15683_Surveillance {

	static class CCTV {
		int num;
		int x;
		int y;

		CCTV(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int[][] map;
	static int[][] copyMap;
	static int[] output;
	static ArrayList<CCTV> cctvList;
	static int[] dx = { -1, 0, 1, 0 }; // up -> right -> down -> left
	static int[] dy = { 0, 1, 0, -1 };
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		cctvList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvList.add(new CCTV(map[i][j], i, j));
				}
			}
		}

		output = new int[cctvList.size()]; // array for permutation
		permutation(0, cctvList.size());

		System.out.println(answer);
	}

	private static void permutation(int depth, int r) {
		if (depth == r) {

			// copying the array
			copyMap = new int[N][M];
			for (int i = 0; i < map.length; i++) {
				System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
			}

			// setting direction
			for (int i = 0; i < cctvList.size(); i++) {
				direction(cctvList.get(i), output[i]);
			}

			getBlindSpot();

			return;
		}

		for (int i = 0; i < 4; i++) {
			output[depth] = i;
			permutation(depth + 1, r);
		}
	}

	private static void direction(CCTV cctv, int d) {
		int cctvNum = cctv.num;

		if (cctvNum == 1) {
			if (d == 0)
				watch(cctv, 0); // up
			else if (d == 1)
				watch(cctv, 1); // right
			else if (d == 2)
				watch(cctv, 2); // down
			else if (d == 3)
				watch(cctv, 3); // left
		} else if (cctvNum == 2) {
			if (d == 0 || d == 2) {
				watch(cctv, 0);
				watch(cctv, 2); // up-down
			} else {
				watch(cctv, 1);
				watch(cctv, 3); // right-left
			}
		} else if (cctvNum == 3) {
			if (d == 0) {
				watch(cctv, 0); // up-right
				watch(cctv, 1);
			} else if (d == 1) {
				watch(cctv, 1); // right-down
				watch(cctv, 2);
			} else if (d == 2) {
				watch(cctv, 2); // down-left
				watch(cctv, 3);
			} else if (d == 3) {
				watch(cctv, 0); // left-up
				watch(cctv, 3);
			}
		} else if (cctvNum == 4) {
			if (d == 0) {
				watch(cctv, 0); // left-up-right
				watch(cctv, 1);
				watch(cctv, 3);
			} else if (d == 1) {
				watch(cctv, 0); // up-right-down
				watch(cctv, 1);
				watch(cctv, 2);
			} else if (d == 2) {
				watch(cctv, 1); // left-down-right
				watch(cctv, 2);
				watch(cctv, 3);
			} else if (d == 3) {
				watch(cctv, 0); // up-left-down
				watch(cctv, 2);
				watch(cctv, 3);
			}
		} else if (cctvNum == 5) { // all direction
			watch(cctv, 0);
			watch(cctv, 1);
			watch(cctv, 2);
			watch(cctv, 3);
		}
	}

	private static void watch(CCTV cctv, int d) {

		Queue<CCTV> queue = new LinkedList<>();
		queue.add(cctv);

		boolean[][] visited = new boolean[N][M];
		visited[cctv.x][cctv.y] = true;

		while (!queue.isEmpty()) {
			CCTV nxt = queue.poll();
			int nx = nxt.x + dx[d];
			int ny = nxt.y + dy[d];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M || copyMap[nx][ny] == 6) {
				break;
			}

			if (copyMap[nx][ny] == 0) {
				copyMap[nx][ny] = -1; // Can be watched
				queue.add(new CCTV(cctv.num, nx, ny));
			} else {
				queue.add(new CCTV(cctv.num, nx, ny)); // passing
			}
		}
	}

	private static void getBlindSpot() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		answer = Math.min(answer, cnt);
	}

}

// reference: https://minhamina.tistory.com/134
