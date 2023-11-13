package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _7964_CyclicPermutation {

    public static final int MOD = 1000000007;
    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> permutations = new ArrayList<>();
        generatePermutations(permutations, N);
        System.out.println(ans % MOD);
    }

    public static void generatePermutations(List<Integer> current, int N) {
        if (current.size() == N) {
            List<int[]> edges = generateEdges(current);
            if (hasCycle(edges, N)) {
                ans++;
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!current.contains(i)) {
                current.add(i);
                generatePermutations(current, N);
                current.remove(current.size() - 1);
            }
        }
    }

    public static List<int[]> generateEdges(List<Integer> list) {
        List<int[]> edges = new ArrayList<>();
        int N = list.size();

        for (int i = 0; i < N; i++) {
            // 조건1
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j) > list.get(i)) {
                    edges.add(new int[] { i + 1, j + 1 });
                    break;
                }
            }

            // 조건2
            for (int j = i + 1; j < N; j++) {
                if (list.get(j) > list.get(i)) {
                    edges.add(new int[] { i + 1, j + 1 });
                    break;
                }
            }
        }

        return edges;
    }

    public static boolean hasCycle(List<int[]> edges, int N) {
        boolean[] visited = new boolean[N];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, graph)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(int current, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[current] = true;

        for (int i : graph.get(current)) {
            if (!visited[i]) {
                if (dfs(i, current, visited, graph)) {
                    return true;
                }
            } else if (i != parent) { // 사이클을 발견한 경우
                return true;
            }
        }
        return false;
    }

}
