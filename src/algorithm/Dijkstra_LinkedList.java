package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra_LinkedList {
    public static class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String[] tmp = br.readLine().split(" ");
            int n = Integer.parseInt(tmp[0]);
            int d = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);

            List<List<Edge>> graph = new ArrayList<>();
            for(int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < d; i++) {
                tmp = br.readLine().split(" ");
                int a = Integer.parseInt(tmp[0]);
                int b = Integer.parseInt(tmp[1]);
                int s = Integer.parseInt(tmp[2]);
                graph.get(b).add(new Edge(a, s));
            }

            int[] dist = dijkstra(graph, c, n);
            int cnt = 0;
            int time = -1;
            for(int i = 0; i < n + 1; i++) {
                if(dist[i] != Integer.MAX_VALUE) {
                    cnt++;
                    time = Math.max(time, dist[i]);
                }                
            }
            System.out.println(cnt + " " + time);
        }

    }

    public static int[] dijkstra(List<List<Edge>> graph, int start, int size) {
        int[] distance = new int[size + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int vertex = current.destination;

            for (Edge neighbor : graph.get(vertex)) {
                int newDistance = distance[vertex] + neighbor.weight;
                if (newDistance < distance[neighbor.destination]) {
                    distance[neighbor.destination] = newDistance;
                    pq.offer(new Edge(neighbor.destination, newDistance));
                }
            }
        }

        return distance;
    }
}
