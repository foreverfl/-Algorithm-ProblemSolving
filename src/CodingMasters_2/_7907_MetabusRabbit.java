package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _7907_MetabusRabbit {

    public static int N, M;
    public static int[] dx = { 0, 1, 0, -1 }; // 동남서북
    public static int[] dy = { 1, 0, -1, 0 };
    public static char[][] map;
    public static boolean[][] visited;

    public static class Point {
        int x;
        int y;
        int time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs());
    }

    public static int bfs() {

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == N - 1 && now.y == M - 1)
                return now.time;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (!isValid(nx, ny) || map[nx][ny] == '#')
                    continue;

                int nx2 = now.x + dx[i] * 2;
                int ny2 = now.y + dy[i] * 2;

                if (isValid(nx2, ny2) && map[nx2][ny2] != '#') {
                    if (!visited[nx2][ny2]) {
                        visited[nx2][ny2] = true;
                        queue.offer(new Point(nx2, ny2, now.time + 1));
                        continue;
                    }
                } else if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, now.time + 1));
                }
            }
        }

        return -1;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
