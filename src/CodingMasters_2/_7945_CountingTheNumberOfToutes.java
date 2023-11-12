package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _7945_CountingTheNumberOfToutes {
    public static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            graph.get(u - 1).add(v - 1);
            graph.get(v - 1).add(u - 1);
        }

        System.out.println(findPaths(n, graph));

    }

    public static int findPaths(int n, List<List<Integer>> graph) {
        int[] distances = new int[n];
        int[] pathCounts = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        pathCounts[0] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.get(current)) {
                if (distances[neighbor] == Integer.MAX_VALUE) {
                    distances[neighbor] = distances[current] + 1;
                    queue.offer(neighbor);
                }
                if (distances[neighbor] == distances[current] + 1) {
                    pathCounts[neighbor] = (pathCounts[neighbor] + pathCounts[current]) % MOD;
                }
            }
        }

        return pathCounts[n - 1];
    }
}
