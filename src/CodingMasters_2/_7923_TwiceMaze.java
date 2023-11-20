package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _7923_TwiceMaze {

    public static class Point {
        int x1, y1, x2, y2, dist;

        Point(int x1, int y1, int x2, int y2, int dist) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.dist = dist;
        }
    }

    public static int H1, W1, H2, W2;
    public static char[][] maze1 = new char[31][31];
    public static char[][] maze2 = new char[31][31];
    public static boolean[][][][] visited = new boolean[31][31][31][31];
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        H1 = Integer.parseInt(input[0]);
        W1 = Integer.parseInt(input[1]);

        int[] start1 = null;
        int[] end1 = null;
        for (int i = 0; i < H1; i++) {
            String line = br.readLine();
            for (int j = 0; j < W1; j++) {
                char c = line.charAt(j);
                if (c == 'S')
                    start1 = new int[] { i, j };
                if (c == 'E')
                    end1 = new int[] { i, j };
                maze1[i][j] = c;
            }
        }

        input = br.readLine().split(" ");
        H2 = Integer.parseInt(input[0]);
        W2 = Integer.parseInt(input[1]);
        int[] start2 = null;
        int[] end2 = null;
        for (int i = 0; i < H2; i++) {
            String line = br.readLine();
            for (int j = 0; j < W2; j++) {
                char c = line.charAt(j);
                if (c == 'S')
                    start2 = new int[] { i, j };
                if (c == 'E')
                    end2 = new int[] { i, j };
                maze2[i][j] = c;
            }
        }

        System.out.println(bfs(start1, end1, start2, end2));
    }

    public static int bfs(int[] start1, int[] end1, int[] start2, int[] end2) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start1[0], start1[1], start2[0], start2[1], 0));
        visited[start1[0]][start1[1]][start2[0]][start2[1]] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (now.x1 == end1[0] && now.y1 == end1[1] && now.x2 == end2[0] && now.y2 == end2[1]) {
                return now.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx1 = now.x1 + dx[i];
                int ny1 = now.y1 + dy[i];
                int nx2 = now.x2 + dx[i];
                int ny2 = now.y2 + dy[i];

                // 벽이면 이동하지 않음
                if (nx1 < 0 || nx1 >= H1 || ny1 < 0 || ny1 >= W1 || maze1[nx1][ny1] == '#') {
                    nx1 = now.x1;
                    ny1 = now.y1;
                }
                if (nx2 < 0 || nx2 >= H2 || ny2 < 0 || ny2 >= W2 || maze2[nx2][ny2] == '#') {
                    nx2 = now.x2;
                    ny2 = now.y2;
                }

                if (!visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    queue.add(new Point(nx1, ny1, nx2, ny2, now.dist + 1));
                }
            }
        }

        return -1;
    }
}
