package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_09370_DestinationUnknown {

    public static class Node implements Comparable<Node> {
        int vertex;
        int dist;

        Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String[] tmp = br.readLine().split(" ");
            int n = Integer.parseInt(tmp[0]);
            int m = Integer.parseInt(tmp[1]);
            int t = Integer.parseInt(tmp[2]);

            tmp = br.readLine().split(" ");
            int s = Integer.parseInt(tmp[0]);
            int g = Integer.parseInt(tmp[1]);
            int h = Integer.parseInt(tmp[2]);

            List<List<Node>> graph = new ArrayList<>();

            for(int i = 0; i < n + 1 ; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < m; i++) {
                tmp = br.readLine().split(" ");
                int a = Integer.parseInt(tmp[0]);
                int b = Integer.parseInt(tmp[1]);
                int d = Integer.parseInt(tmp[2]);
                graph.get(a).add(new Node(b, d));
                graph.get(b).add(new Node(a, d));
            }

            int[] destinations = new int[t];
            for (int i = 0; i < t; i++) {
                destinations[i] = Integer.parseInt(br.readLine());
            }

            int[] distFromS = dijkstra(graph, s);
            int[] distFromG = dijkstra(graph, g);
            int[] distFromH = dijkstra(graph, h);

            Arrays.sort(destinations);

            for (int destination : destinations) {
                int distSGH = distFromS[g] + distFromG[h] + distFromH[destination];
                int distSHG = distFromS[h] + distFromH[g] + distFromG[destination];
                int distST = distFromS[destination];

                if (distSGH == distST || distSHG == distST) {
                    System.out.print(destination + " ");
                }
            }
            System.out.println();
        }
    }

    public static int[] dijkstra(List<List<Node>> graph, int start) {
        int n = graph.size() - 1;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int vertex = node.vertex;
            int distance = node.dist;

            if (distance > dist[vertex]) {
                continue;
            }

            for (Node neighbor : graph.get(vertex)) {
                int newDistance = distance + neighbor.dist;
                if (newDistance < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = newDistance;
                    pq.offer(new Node(neighbor.vertex, newDistance));
                }
            }
        }

        return dist;
    }
}
