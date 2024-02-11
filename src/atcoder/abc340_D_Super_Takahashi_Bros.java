package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class abc340_D_Super_Takahashi_Bros {

    public static class Stage implements Comparable<Stage> {
        int stage;
        long time;

        Stage(int stage, long time) {
            this.stage = stage;
            this.time = time;
        }

        @Override
        public int compareTo(Stage other) {
            return Long.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Stage>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int currentStage = 1; currentStage < N; currentStage++) {
            String[] input = br.readLine().split(" ");
            long A = Long.parseLong(input[0]);
            long B = Long.parseLong(input[1]);
            int X = Integer.parseInt(input[2]);

            graph.get(currentStage).add(new Stage(currentStage + 1, A));
            if (X <= N) {
                graph.get(currentStage).add(new Stage(X, B));
            }
        }

        // dijkstra
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Stage> pq = new PriorityQueue<>();
        pq.offer(new Stage(1, 0));

        while (!pq.isEmpty()) {
            Stage current = pq.poll();

            if (dist[current.stage] < current.time)
                continue;

            for (Stage next : graph.get(current.stage)) {
                if (dist[next.stage] > dist[current.stage] + next.time) {
                    dist[next.stage] = dist[current.stage] + next.time;
                    pq.offer(new Stage(next.stage, dist[next.stage]));
                }
            }
        }

        System.out.println(dist[N]);
    }
}
