package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_01261_Algospot {
    static int n, m;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static final int MAX = 100;

    static class Pair implements Comparable<Pair> {
        int cost;
        int x;
        int y;

        public Pair(int cost, int x, int y) {
            this.cost = cost;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void dijkstra() {
        ArrayDeque<Pair> pq = new ArrayDeque<>(); // cost 순으로 정렬
        pq.add(new Pair(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;
                if (dist[nx][ny] > dist[x][y] + map[nx][ny]) {
                    dist[nx][ny] = dist[x][y] + map[nx][ny];
                    pq.add(new Pair(-dist[nx][ny], nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; ++i) {
            String row = br.readLine();
            for (int j = 0; j < m; ++j) {
                map[i][j] = row.charAt(j) - '0';
            }
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dijkstra();
        System.out.println(dist[n - 1][m - 1]);
    }
}

// reference: https://developingbear.tistory.com/141