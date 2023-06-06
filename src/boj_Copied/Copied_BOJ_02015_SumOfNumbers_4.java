package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Copied_BOJ_02015_SumOfNumbers_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        long n = Long.parseLong(tmp[0]);
        long k = Long.parseLong(tmp[1]);

        long[] prefixSum = new long[(int) (n + 1)];
        Map<Long, Long> map = new HashMap<>();

        tmp = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            long num = Long.parseLong(tmp[i - 1]);
            prefixSum[i] = prefixSum[i - 1] + num;
        }

        long ans = 0;

        for (int i = 1; i <= n; i++) {
            if (prefixSum[i] == k) {
                ans++;
            }
            if (map.containsKey(prefixSum[i] - k)) {
                ans += map.get(prefixSum[i] - k);
            }
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0L) + 1);

        }

        System.out.println(ans);
    }
}

// reference: https://mangu.tistory.com/100