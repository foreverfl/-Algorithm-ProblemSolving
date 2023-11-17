package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _7888_Neighbor {

    public static int[] weights;

    public static class Edge {
        int from;
        int to;

        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public String toString() {
            return "( " + from + ", " + to + " )";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1;
            int v = Integer.parseInt(input[1]) - 1;
            edges.add(new Edge(u, v));
        }
        // System.out.println(edges);

        boolean changed;
        int totalCost = 0;
        do {
            changed = false;
            for (Edge edge : edges) {
                int weightDiff = Math.abs(weights[edge.from] - weights[edge.to]);
                if (weightDiff > K) {
                    int needed = weightDiff - K;
                    if (weights[edge.from] < weights[edge.to]) {
                        weights[edge.from] += needed;
                    } else {
                        weights[edge.to] += needed;
                    }
                    totalCost += needed;
                    changed = true;
                }
            }
        } while (changed);

        // System.out.println(Arrays.toString(weights));
        System.out.println(totalCost);

    }

}