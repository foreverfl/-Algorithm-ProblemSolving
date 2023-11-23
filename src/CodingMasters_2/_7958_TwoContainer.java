package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class _7958_TwoContainer {
    public static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");
        int S1 = Integer.parseInt(line[0]);
        int D1 = Integer.parseInt(line[1]);
        int S2 = Integer.parseInt(line[2]);
        int D2 = Integer.parseInt(line[3]);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        if (isLinearGraph(graph)) {
            System.out.println(-1);
            return;
        }

        int result = bfs(S1, D1, S2, D2, graph);
        System.out.println(result);
    }

    public static int bfs(int S1, int D1, int S2, int D2, List<List<Integer>> graph) {
        Queue<Pair> queue = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        queue.offer(new Pair(S1, S2));
        visited.add(new Pair(S1, S2));

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                int currentFirst = current.first;
                int currentSecond = current.second;

                if (currentFirst == D1 && currentSecond == D2) {
                    return steps;
                }

                // 컨테이너 1
                for (int next : graph.get(currentFirst)) {
                    if (next != currentSecond && !visited.contains(new Pair(next, currentSecond))) {
                        queue.offer(new Pair(next, currentSecond));
                        visited.add(new Pair(next, currentSecond));
                    }
                }

                // 컨테이너 2
                for (int next : graph.get(currentSecond)) {
                    if (next != currentFirst && !visited.contains(new Pair(currentFirst, next))) {
                        queue.offer(new Pair(currentFirst, next));
                        visited.add(new Pair(currentFirst, next));
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    public static boolean isLinearGraph(List<List<Integer>> graph) {
        int endPoints = 0;

        for (List<Integer> edges : graph) {
            if (edges.size() == 1)
                endPoints++;
            else if (edges.size() > 2)
                return false;
        }

        return endPoints == 2;
    }
}
