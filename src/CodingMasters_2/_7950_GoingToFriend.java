package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _7950_GoingToFriend {
    public static int N;
    public static int[][] map;
    public static boolean[][][] visited; // 0: 높은 칸으로 이동 사용 안 함, 1: 높은 칸으로 이동 사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N][2];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, 0 }); // x, y, 높은 칸으로 이동 사용 여부
        visited[0][0][0] = true;

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int usedHighJump = current[2];

                if (x == N - 1 && y == N - 1)
                    return steps + 1; // 최소 칸수이기 때문에 1을 더해줌

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                        continue;

                    if (map[nx][ny] <= map[x][y] && !visited[nx][ny][usedHighJump]) {
                        visited[nx][ny][usedHighJump] = true;
                        queue.add(new int[] { nx, ny, usedHighJump });
                    }

                    if (usedHighJump == 0 && !visited[nx][ny][1] && map[nx][ny] > map[x][y]) {
                        visited[nx][ny][1] = true;
                        queue.add(new int[] { nx, ny, 1 });
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
