package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solving_7909_Confidence {
    public static class Player implements Comparable<Player> {
        long weight, worries;

        Player(long weight, long worries) {
            this.weight = weight;
            this.worries = worries;
        }

        // '몸무게 - 걱정거리' 값으로 정렬
        @Override
        public int compareTo(Player other) {
            return Long.compare(this.weight, other.weight);
        }

        public String toString() {
            return "weight: " + weight + " / worries: " + worries;
        }
    }

    public static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Player[] players = new Player[N];

        String[] input = br.readLine().split(" ");
        long initialWeight = Long.parseLong(input[0]);
        long initialWorries = Long.parseLong(input[1]);
        players[0] = new Player(initialWeight, initialWorries);

        input = br.readLine().split(" ");
        long multiplierW = Long.parseLong(input[0]);
        long multiplierP = Long.parseLong(input[1]);

        int K = Integer.parseInt(br.readLine());
        Map<Integer, long[]> updates = new HashMap<>();
        for (int i = 0; i < K; i++) {
            input = br.readLine().split(" ");
            int u1 = Integer.parseInt(input[0]);
            long u2 = Long.parseLong(input[1]);
            long u3 = Long.parseLong(input[2]);
            updates.put(u1, new long[] { u2, u3 });
        }

        for (int i = 1; i < N; i++) {
            if (updates.containsKey(i)) {
                long[] update = updates.get(i);
                multiplierW = update[0];
                multiplierP = update[1];
            }
            long newWeight = (players[i - 1].weight * multiplierW) % MOD;
            long newWorries = (players[i - 1].worries * multiplierP) % MOD;
            players[i] = new Player(newWeight, newWorries);
        }

        Arrays.sort(players);
        System.out.println(Arrays.toString(players));

        long totalConfidentWins = 0;
        for (int i = 0; i < N; i++) {
            int j = i + 1;
            while (j < N && players[i].weight - players[i].worries > players[j].weight) {
                totalConfidentWins++;
                j++;
            }
        }

        System.out.println(totalConfidentWins % MOD);

    }

}
