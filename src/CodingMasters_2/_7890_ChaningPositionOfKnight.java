package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7890_ChaningPositionOfKnight {

    public static char[][] map = new char[3][3];
    public static int[] dx = { -1, +1, -2, -2, +2, +2, -1, +1 };
    public static int[] dy = { +2, +2, +1, -1, -1, +1, -2, -2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[][] visited = new boolean[3][3];
                if (map[i][j] == '1') {
                    if (!dfs(i, j, '2', visited)) {
                        System.out.println("impossible");
                        System.exit(0);
                    }
                }

                if (map[i][j] == '2') {
                    if (!dfs(i, j, '1', visited)) {
                        System.out.println("impossible");
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("possible");
    }

    public static boolean dfs(int x, int y, char target, boolean[][] visited) {
        if (map[x][y] == target) {
            return true;
        }

        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] != map[x][y]) {
                if (dfs(nx, ny, target, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < 3 && y >= 0 && y < 3;
    }
}
