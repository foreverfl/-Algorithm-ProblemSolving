package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solving_7897_WalkingTrail {

    public static final int[] dx = { 0, 1, 0, -1 }; // 동남서북
    public static final int[] dy = { 1, 0, -1, 0 };
    public static boolean[][][] visited; // 방향에 따른 방문 기록
    public static int N;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 동쪽으로 시작
        visited = new boolean[2 * N + 1][2 * N + 1][4];
        for (int i = 0; i < 4; i++) {
            visited[0][0][i] = true;
            dfs(0, 0, i, 0, i);
        }

        System.out.println(count);

    }

    public static void dfs(int x, int y, int dir, int steps, int startDir) {
        if (steps == N) {
            count++;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nextDir = (dir + (i == 0 ? 1 : 3)) % 4; // i가 0이면 오른쪽 회전, 아니면 왼쪽 회전
            int nx = x + dx[nextDir];
            int ny = y + dy[nextDir];

            if (!isValid(nx, ny))
                continue;

            if (visited[nx][ny][startDir])
                continue;

            visited[nx][ny][dir] = true;
            dfs(nx, ny, nextDir, steps + 1, startDir);
            visited[nx][ny][dir] = false;
        }
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < 2 * N + 1 && y >= 0 && y < 2 * N + 1;
    }
}