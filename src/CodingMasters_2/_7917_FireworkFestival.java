package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class _7917_FireworkFestival {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = -10_0000_0000;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, findMaxSumSubArray(arr, i));
        }

        System.out.println(max);

    }

    public static int findMaxSumSubArray(int[] numbers, int k) {
        int maxSum = -10_0000_0000;
        int windowSum = 0;
        int start = 0;

        for (int end = 0; end < numbers.length; end++) {
            windowSum += numbers[end];

            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= numbers[start];
                start++;
            }
        }

        return maxSum;
    }

}
