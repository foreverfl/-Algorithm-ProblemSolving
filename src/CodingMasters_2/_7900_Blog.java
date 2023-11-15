package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class _7900_Blog {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] cumSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cumSum[i] = cumSum[i - 1] + arr[i - 1];
        }

        int max = -1;
        int ans = 0;
        for (int i = 0; i <= N - K; i++) {
            int sum = cumSum[i + K] - cumSum[i]; // 구간 합
            if (sum >= max) { // 가장 빠른 날을 출력
                max = sum;
                ans = i + 1;
            }
        }

        System.out.println(ans);
    }
}
