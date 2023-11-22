package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class _7964_CyclicPermutation {

    public static final int MOD = 1000000007;
    public static int ans;
    public static int cnt_no_cycle;
    public static int permutation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(calculateSequence(N));

        // for (int i = 3; i <= 10; i++) {
        // List<Integer> permutations = new ArrayList<>();
        // generatePermutations(permutations, i);
        // System.out.println(
        // "[" + i + "] cnt_no_cycle: " + cnt_no_cycle + " / permutation: " +
        // permutation + " / ans: " + ans);
        // ans = 0;
        // cnt_no_cycle = 0;
        // permutation = 0;
        // }
    }

    public static long calculateSequence(int n) {
        BigInteger factorial = factorial(n);
        BigInteger powerOfTwo = BigInteger.valueOf(2).pow(n - 1);
        BigInteger mod = BigInteger.valueOf(MOD);

        BigInteger result = factorial.subtract(powerOfTwo).mod(mod);
        return result.longValue();
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i)).mod(BigInteger.valueOf(MOD));
        }
        return result;
    }

    public static void generatePermutations(List<Integer> current, int N) {
        if (current.size() == N) {
            permutation++;
            List<int[]> edges = generateEdges(current);
            if (hasCycle(edges, N)) {
                ans++;
            } else {
                cnt_no_cycle++;
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
