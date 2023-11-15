package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class _7919_Musical {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(findMinimumDays(N, K, arr));
    }

    public static int findMinimumDays(int N, int K, int[] actors) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int start = 0, minDays = N;
        int uniqueActors = 0;

        for (int end = 0; end < N; end++) {
            countMap.put(actors[end], countMap.getOrDefault(actors[end], 0) + 1);
            if (countMap.get(actors[end]) == 1) {
                uniqueActors++;
            }

            while (uniqueActors == K) {
                minDays = Math.min(minDays, end - start + 1);
                countMap.put(actors[start], countMap.get(actors[start]) - 1);
                if (countMap.get(actors[start]) == 0) {
                    uniqueActors--;
                }
                start++;
            }
        }

        return minDays;
    }
}
