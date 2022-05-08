package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_16236_BabyShark {

	static class Node {
		int x;
		int y;
		int dist;

		Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static int[][] map;
	static int[][] dist;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 9)
					bfs(i, j);
			}
		}

	}

	private static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		int eat = 0;
		int time = 0;
		int size = 2;

		while (true) {

			LinkedList<Node> fish = new LinkedList<>();
			dist = new int[N][N];
			queue.add(new Node(x, y, 0));

			while (!queue.isEmpty()) {

				Node current = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nx = current.x + dx[i];
					int ny = current.y + dy[i];

					if (nx >= 0 && ny >= 0 && nx < N && ny < N && dist[nx][ny] == 0 && map[nx][ny] <= size) {
						dist[nx][ny] = dist[current.x][current.y] + 1;
						queue.add(new Node(nx, ny, dist[nx][ny]));
						if (1 <= map[nx][ny] && map[nx][ny] <= 6 && map[nx][ny] < size)
							fish.add(new Node(nx, ny, dist[nx][ny]));
					}
				}

			}

			if (fish.size() == 0) {
				System.out.println(time);
				return;
			}

			Node currentFish = fish.get(0);
			for (int i = 1; i < fish.size(); i++) {
				if (currentFish.dist > fish.get(i).dist) { // 첫 값을 거리가 짧은 물고기로 갱신
					currentFish = fish.get(i);
				} else if (currentFish.dist == fish.get(i).dist) { // 거리가 같다면 
					if (currentFish.x > fish.get(i).x) // 위쪽에 있는 물고기로 갱신
						currentFish = fish.get(i);
					else if (currentFish.x == fish.get(i).x) { // 위쪽에 있는게 같다면
						if (currentFish.y > fish.get(i).y) // 왼쪽에 있는 물고기로 갱신
							currentFish = fish.get(i);
					}
				}
			}

			time += currentFish.dist;
			eat++;
			map[currentFish.x][currentFish.y] = 0; // 먹었으니까 0으로 바꿔줌
			if (eat == size) {
				size++;
				eat = 0;
			}
			queue.add(new Node(currentFish.x, currentFish.y, 0)); // 먹고 나서 이동함

		}

	}
}

// reference: https://moonsbeen.tistory.com/231
