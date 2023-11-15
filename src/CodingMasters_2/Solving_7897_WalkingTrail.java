package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solving_7897_WalkingTrail {

    public static final int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 동남서북
    public static boolean[][] visited;
    public static int N;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 동쪽으로 시작
        visited = new boolean[2 * N + 1][2 * N + 1];
        visited[0][0] = true;
        dfs(0, 0, 0, 0);

        System.out.println(count);

    }

    public static void dfs(int x, int y, int dir, int steps) {
        if (steps == N) {
            count++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextDir = (dir + i) % 4;
            int nx = x + directions[nextDir][0];
            int ny = y + directions[nextDir][1];

            if (!isValid(nx, ny))
                continue;

            if (visited[nx][ny])
                continue;

            visited[nx][ny] = true;
            dfs(nx, ny, nextDir, steps + 1);
            visited[nx][ny] = false;

        }
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < 2 * N + 1 && y >= 0 && y < 2 * N + 1;
    }
}
