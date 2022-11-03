package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_16236_BabyShark {

	static class Shark {
		int x;
		int y;
		int dist;

		public Shark(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static int N;
	static int[][] map;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static ArrayList<Shark> fishes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		Queue<Shark> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					queue.add(new Shark(i, j, 0));
					map[i][j] = 0;
				}
			}
		}

		int exp = 0;
		int time = 0;
		int size = 2;

		while (true) {
			LinkedList<Shark> fish = new LinkedList<>();
			int[][] dist = new int[N][N];

			while (!queue.isEmpty()) {
				Shark now = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];

					if (nx >= N || ny >= N || nx < 0 || ny < 0)
						continue;

					if (dist[nx][ny] == 0 && map[nx][ny] <= size) {
						dist[nx][ny] = dist[now.x][now.y] + 1;
						queue.add(new Shark(nx, ny, dist[nx][ny]));
						
						if (1 <= map[nx][ny] && map[nx][ny] <= 6 && map[nx][ny] < size)
							fish.add(new Shark(nx, ny, dist[nx][ny]));
					}
				}
			}

			if (fish.size() == 0) {
				System.out.println(time);
				return;
			}

			Shark currentFish = fish.get(0);
			for (int i = 1; i < fish.size(); i++) {
				if (currentFish.dist > fish.get(i).dist) {
					currentFish = fish.get(i);
				} else if (currentFish.dist == fish.get(i).dist) {
					if (currentFish.x > fish.get(i).x)
						currentFish = fish.get(i);
					else if (currentFish.x == fish.get(i).x) {
						if (currentFish.y > fish.get(i).y)
							currentFish = fish.get(i);
					}
				}
			}

			time += currentFish.dist;
			exp++;
			map[currentFish.x][currentFish.y] = 0;
			if (exp == size) {
				size++;
				exp = 0;
			}
			queue.add(new Shark(currentFish.x, currentFish.y, 0));
		}
	}

}

// reference: https://moonsbeen.tistory.com/231
