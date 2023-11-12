package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solving_7960_ExploringSpace {

    static class Edge implements Comparable<Edge> {

        int u;
        int v;
        int w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }

    }

    static class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        ArrayList<Edge> edges = new ArrayList<>();
        UnionFind uf = new UnionFind(N);

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1;
            int v = Integer.parseInt(input[1]) - 1;
            int w = Integer.parseInt(input[2]);
            w = Math.max(K, w); // 최대값 5로 조정
            edges.add(new Edge(u, v, w));
            uf.union(u, v);
        }

        Collections.sort(edges);

        int totalCost = 0;
        for (Edge edge : edges) {
            int rootU = uf.find(edge.u);
            int rootV = uf.find(edge.v);
            if (rootU != rootV) {
                totalCost += edge.w;
                uf.union(rootU, rootV);
            }
        }

        Set<Integer> uniqueRoots = new HashSet<>();
        for (int i = 0; i < N; i++) {
            uniqueRoots.add(uf.find(i));
        }

        totalCost += (uniqueRoots.size() - 1) * K;

        System.out.println(totalCost);
    }
}
