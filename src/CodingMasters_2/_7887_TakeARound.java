package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _7887_TakeARound {

    static class Edge {
        int s;
        int e;

        Edge(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]) - 1;
            int e = Integer.parseInt(input[1]) - 1;
            graph.get(s).add(e);
        }

        boolean[] visited = new boolean[N];
        System.out.println(isRound(0, visited, graph, false) ? "YES" : "NO");
    }

    public static boolean isRound(int current, boolean[] visited, List<List<Integer>> graph, boolean visitedOther) {
        visited[current] = true;

        if (current != 0)
            visitedOther = true;

        for (int next : graph.get(current)) {
            if (next == 0 && visitedOther)
                return true;
            if (!visited[next]) {
                if (isRound(next, visited, graph, visitedOther)) {
                    return true;
                }
            }
        }

        return false;
    }

}
