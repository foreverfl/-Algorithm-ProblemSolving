package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class Programmers_150365_EscapingTheMaze {
    public static void main(String[] args) {
        System.out.println(solution(3, 4, 2, 3, 3, 1, 5));
        System.out.println(solution(2, 2, 1, 1, 2, 2, 2));
        System.out.println(solution(3, 3, 1, 2, 3, 3, 4));
    }

    // 일반적인 좌표와 방향이 반대
    // 남서동북(dlru순)
    public static int[] dx = {1, 0, 0, -1};
    public static int[] dy = {0, -1, 1, 0};

    public static class Point {
        public int x, y;
        public StringBuilder sb;

        public Point(int x, int y, StringBuilder sb) {
            this.x = x;
            this.y = y;
            this.sb = sb;
        }
    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        boolean[][][] visited = new boolean[n][m][k + 1]; // 좌표에 이동거리 k로 도달했는지를 체크
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x - 1, y - 1, new StringBuilder()));
        visited[x - 1][y - 1][0] = true;

        while(!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.x == r - 1 && cur.y == c - 1) {
                if (cur.sb.toString().length() == k)
                    return cur.sb.toString();
            }

            if (cur.sb.toString().length() == k)
                continue;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny][cur.sb.toString().length() + 1])
                    continue;

                visited[nx][ny][cur.sb.toString().length() + 1] = true;
                queue.add(new Point(nx, ny, new StringBuilder(cur.sb).append(convertDir(d))));
            }
        }
        
        return "impossible";
    }

    public static char convertDir(int d) {
        if (d == 0)
            return 'd';
        if (d == 1)
            return 'l';
        if (d == 2)
            return 'r';
        if (d == 3)
            return 'u';
        return '0';
    }
}

// reference: https://velog.io/@ddongh1122/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%AF%B8%EB%A1%9C-%ED%83%88%EC%B6%9C-%EB%AA%85%EB%A0%B9%EC%96%B4