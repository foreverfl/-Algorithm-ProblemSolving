package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solving_7909_Confidence {
    public static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] weight = new long[N];
        long[] worries = new long[N];

        String[] input = br.readLine().split(" ");
        weight[0] = Long.parseLong(input[0]);
        worries[0] = Long.parseLong(input[1]);

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
            weight[i] = (weight[i - 1] * multiplierW) % MOD;
            worries[i] = (worries[i - 1] * multiplierP) % MOD;
        }

        long sum = 0;
        long[] confidenceLevels = new long[N];
        for (int i = 0; i < N; i++) {
            confidenceLevels[i] = weight[i] - worries[i];
        }
        Arrays.sort(confidenceLevels);

        for (int i = 0; i < N; i++) {
            long target = weight[i] - worries[i];
            int count = lowerBound(confidenceLevels, target);
            sum = (sum + count) % MOD;
        }

        System.out.println(sum);
    }

    public static int lowerBound(long[] array, long target) {
        int low = 0;
        int high = array.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
