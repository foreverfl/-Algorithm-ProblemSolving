package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class _7898_NIMBY {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int maxSatisfaction = Integer.MIN_VALUE;
        int loc = arr[0];
        for (int pos : arr) {
            int satisfaction = 0;
            for (int j = 0; j < N; j++) {
                int distance = Math.abs(arr[j] - pos);
                satisfaction += distance <= K ? distance : -distance;
            }
            if (satisfaction > maxSatisfaction) {
                maxSatisfaction = satisfaction;
                loc = pos;
            }
        }
        System.out.println(loc);
    }
}
