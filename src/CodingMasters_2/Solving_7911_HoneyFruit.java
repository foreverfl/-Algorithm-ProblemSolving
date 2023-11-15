package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solving_7911_HoneyFruit {

    static class Point {
        int x, y, day, honeyEffect;
        boolean ateHoney;

        public Point(int x, int y, int day, boolean ateHoney, int honeyEffect) {
            this.x = x;
            this.y = y;
            this.day = day;
            this.ateHoney = ateHoney;
            this.honeyEffect = honeyEffect;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Point start = null;
        Point end = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'A') {
                    start = new Point(i, j, 0, false, 0);
                } else if (map[i][j] == 'B') {
                    end = new Point(i, j, 0, false, 0);
                }
            }
        }

        System.out.println(escapeMaze(N, M, map, start, end));

    }

    public static int escapeMaze(int N, int M, char[][] map, Point start, Point end) {
        boolean[][][] visited = new boolean[N][M][2];
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        PriorityQueue<Point> queue = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.day, p2.day));
        queue.offer(new Point(start.x, start.y, 0, false, 0));
        visited[start.x][start.y][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == end.x && now.y == end.y) {
                return now.day;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int honeyIndex = now.ateHoney ? 1 : 0;

                if (!isValid(nx, ny, N, M) || visited[nx][ny][honeyIndex])
                    continue;

                if (map[nx][ny] == '#') {
                    continue;
                }

                visited[nx][ny][honeyIndex] = true;

                if (now.honeyEffect == 1) {
                    if (map[nx][ny] == 'G') {
                        queue.offer(new Point(nx, ny, now.day, true, 1));
                    } else {
                        queue.offer(new Point(nx, ny, now.day, false, 1));
                    }
                } else {
                    if (map[nx][ny] == 'G') {
                        queue.offer(new Point(nx, ny, now.day + 1, true, 1));
                    } else {
                        queue.offer(new Point(nx, ny, now.day + 1, false, 1));
                    }
                }

            }
        }

        return -1;
    }

    public static boolean isValid(int x, int y, int N, int M) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
