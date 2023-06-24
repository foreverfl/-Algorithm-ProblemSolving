package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_67259_ConstructingRaceTrack {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        System.out.println(solution(new int[][] {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}}));
        System.out.println(solution(new int[][] {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}}));
        System.out.println(solution(new int[][] {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}}));
    }

    public static int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            // 현재 위치의 처리 (여기서는 예시로 숫자 더하기)
            answer += board[x][y];
            
            // 현재 위치의 인접한 칸들을 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 인접한 칸이 유효하고 방문하지 않았다면 큐에 추가하고 visited 표시
                if (isValid(nx, ny, n) && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return answer;
    }

    public static boolean isValid(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
