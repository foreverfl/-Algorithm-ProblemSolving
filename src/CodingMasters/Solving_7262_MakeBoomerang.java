package CodingMasters;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solving_7262_MakeBoomerang {

    public static int[][][] block = {
            { { 0, 0 }, { 0, 1 }, { 1, 1 } }, // 'ㄱ'모양부터 시계방향으로 회전
            { { 0, 1 }, { 1, 1 }, { 1, 0 } },
            { { 1, 1 }, { 1, 0 }, { 0, 0 } },
            { { 1, 0 }, { 0, 0 }, { 0, 1 } } };

    public static int[][] material;
    public static boolean[][] visited;
    public static int N, M;
    public static int max_strength = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        material = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                material[i][j] = Integer.parseInt(input[j]);
            }
        }

        backtracking(0, 0, 0);
        System.out.println(max_strength);

    }

    public static void backtracking(int x, int y, int strength) {
        if (y == M) {
            x++;
            y = 0;
        }

        if (x == N) {
            max_strength = Math.max(max_strength, strength);
            return;
        }

        if (visited[x][y]) {
            backtracking(x, y + 1, strength);
            return;
        }

        // 부메랑을 놓지 않는 경우
        backtracking(x, y + 1, strength);

        // 4가지 모양의 부메랑을 놓는 경우
        for (int i = 0; i < 4; i++) {
            int new_strength = material[x][y] * 2; // 중심 부분은 2배
            boolean canPlace = true;
            for (int j = 0; j < 3; j++) {
                int nx = x + block[i][j][0];
                int ny = y + block[i][j][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
                    canPlace = false;
                    break;
                }
                new_strength += material[nx][ny];
            }
            if (canPlace) {
                visited[x][y] = true;
                for (int j = 0; j < 3; j++) {
                    int nx = x + block[i][j][0];
                    int ny = y + block[i][j][1];
                    visited[nx][ny] = true;
                }
                backtracking(x, y + 1, strength + new_strength);
                visited[x][y] = false;
                for (int j = 0; j < 3; j++) {
                    int nx = x + block[i][j][0];
                    int ny = y + block[i][j][1];
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
