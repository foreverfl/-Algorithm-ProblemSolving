package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solving_7911_HoneyFruit {

    static class Coord {
        int x, y, day, movesLeft;
        boolean ateHoney;

        public Coord(int x, int y, int day, int movesLeft, boolean ateHoney) {
            this.x = x;
            this.y = y;
            this.day = day;
            this.movesLeft = movesLeft;
            this.ateHoney = ateHoney;
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

        Coord start = null;
        Coord end = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'A') {
                    start = new Coord(i, j, 0, 0, false);
                } else if (map[i][j] == 'B') {
                    end = new Coord(i, j, -1, 0, false);
                }
            }
        }

        System.out.println(escapeMaze(N, M, map, start, end));

    }

    public static int escapeMaze(int N, int M, char[][] map, Coord start, Coord end) {
        boolean[][][] visited = new boolean[N][M][2];
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        PriorityQueue<Coord> queue = new PriorityQueue<>((a, b) -> a.day - b.day);
        queue.offer(new Coord(start.x, start.y, 0, 1, false));
        visited[start.x][start.y][0] = true;

        while (!queue.isEmpty()) {
            Coord now = queue.poll();

            if (now.movesLeft == 0 && !now.ateHoney) {
                now.day++;
                now.movesLeft = 1; // 하루에 한 칸씩 이동 가능하도록 리셋
            }

            if (now.x == end.x && now.y == end.y) {
                return now.day;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int ateHoney = now.movesLeft > 1 ? 1 : 0;

                if (!isValid(nx, ny, N, M))
                    continue;

                if (visited[nx][ny][ateHoney])
                    continue;

                if (map[nx][ny] != '#') {
                    visited[nx][ny][ateHoney] = true;

                    if (map[nx][ny] == 'G') {
                        queue.offer(new Coord(nx, ny, now.day, 2, true));
                    } else {
                        queue.offer(new Coord(nx, ny, now.day, now.movesLeft - 1, now.ateHoney));
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
