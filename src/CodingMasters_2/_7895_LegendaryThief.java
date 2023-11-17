package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _7895_LegendaryThief {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        System.out.println(bfs(K, N));
    }

    public static int bfs(int start, int target) {
        if (start == target) {
            return 0;
        }

        boolean[] visited = new boolean[10_0001];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { start, 0 }); // 현재 위치와 워프 횟수

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curPos = current[0];
            int count = current[1];

            int[] nextPositions = { curPos + 3, curPos - 1, curPos * 2 };
            for (int nextPos : nextPositions) {
                if (nextPos == target) {
                    return count + 1;
                }
                if (nextPos >= 0 && nextPos <= 100000 && !visited[nextPos]) {
                    visited[nextPos] = true;
                    queue.offer(new int[] { nextPos, count + 1 });
                }
            }
        }

        return -1;
    }
}
