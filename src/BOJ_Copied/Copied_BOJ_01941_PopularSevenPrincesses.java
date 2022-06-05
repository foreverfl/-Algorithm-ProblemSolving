package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Copied_BOJ_01941_PopularSevenPrincesses {

	static char[][] map = new char[5][5];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[] combX = new int[25];
	static int[] combY = new int[25];
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// making coordinates
		for (int i = 0; i < 25; i++) {
			combX[i] = i % 5;
			combY[i] = i / 5;
		}

		backtracking(new int[7], 0, 0, 7);
		System.out.println(ans);
	}

	// picking 7 among 25
	private static void backtracking(int[] combination, int index, int count, int left) {

		if (left == 0) {
			bfs(combination);
			return;
		}

		if (count == 25)
			return;

		combination[index] = count;
		backtracking(combination, index + 1, count + 1, left - 1); // in
		backtracking(combination, index, count + 1, left); // out
	}

	private static void bfs(int[] comb) {

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[7];

		queue.add(comb[0]);
		int count = 1, countS = 0;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			if (map[combY[now]][combX[now]] == 'S')
				countS++;

			for (int i = 0; i < 4; i++) {
				for (int a = 1; a < 7; a++) {

					if (!visited[a] && combX[now] + dx[i] == combX[comb[a]] && combY[now] + dy[i] == combY[comb[a]]) {
						visited[a] = true;
						queue.add(comb[a]);
						count++;
					}

				}
			}

		}

		if (count == 7) {
			if (countS >= 4) {
				ans++;
			}
		}
	}

}

// reference: https://howtolivelikehuman.tistory.com/248
