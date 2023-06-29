package programmers_Copied;

import java.util.LinkedList;
import java.util.Queue;

public class Copied_Programmers_67259_ConstructingTrack {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        System.out.println(solution(new int[][] {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}}));
        System.out.println(solution(new int[][] {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}}));
        System.out.println(solution(new int[][] {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}}));
    }

    public static class Node {
        int r, c, dir, cost;

        public Node(int r, int c, int dir, int cost) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cost = cost;
        }
    }

    public static int N;
    public static int [][][] visited;
    public static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public static int solution(int[][] board) {
        N = board.length;
        visited = new int[N][N][4];

        return bfs(board);
    }
    
    public static int bfs(int[][] board) {
        int x = 0, y = 0, direction = -1, cost = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x, direction, cost));

        int min_cost = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.r == N - 1 && now.c == N - 1) {
                min_cost = Math.min(min_cost, now.cost);
            }

            for(int dir = 0; dir < 4; dir++) {
                int dr = now.r + d[dir][0];
                int dc = now.c + d[dir][1];

                if(dr < 0 || dr >= N || dc < 0 || dc >= N || board[dr][dc] == 1) {
                    continue;
                }

                int nextCost = now.cost;
                if(now.dir == -1 || now.dir == dir) { // 처음 or 이전과 같은 방향인 경우
                    nextCost += 100;
                }
                else {
                    nextCost += 600;
                }

                if(visited[dr][dc][dir] == 0 || board[dr][dc] >= nextCost) {
                    q.add(new Node(dr, dc, dir, nextCost));
                    visited[dr][dc][dir] = 1;
                    board[dr][dc] = nextCost;
                }
            }
        }
        return min_cost;
    }

}

// reference: https://jie0025.tistory.com/312