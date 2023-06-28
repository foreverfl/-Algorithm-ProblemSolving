package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Programmers_49189_FarthestNode {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    public static int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[1] = true;
        distance[1] = 0;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int neighbor : graph.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[vertex] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        int max = Arrays.stream(distance).max().orElse(0);
        long ans = Arrays.stream(distance).filter(num -> num == max).count();

        return (int) ans;
    }
}
