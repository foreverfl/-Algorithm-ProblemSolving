package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Copied_BOJ_04485_Zelda {

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.y, other.y);
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};    
    static int n;
    static int[][] arr;
    static int[][] dist;

    public static void dijkstra() {
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(0, 0));
        dist[0][0] = arr[0][0];

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int x = current.x;
            int y = current.y;            

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];               

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int ncost = arr[nx][ny];
                    int before_v = dist[nx][ny];
                    int current_v = dist[x][y] + ncost;
                    if (before_v > current_v) { // 최소값 갱신
                        dist[nx][ny] = current_v;
                        pq.offer(new Pair(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 1;

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;

            arr = new int[n][n];
            dist = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(line[j]);
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            dijkstra();
            System.out.println("Problem " + idx++ + ": " + dist[n - 1][n - 1]);
        }

        br.close();
    }
}

// reference: https://gusdnr69.tistory.com/248