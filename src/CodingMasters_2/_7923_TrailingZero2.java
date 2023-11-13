package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7923_TrailingZero2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = findMinimumNumberWithTrailingZeros(n);
        System.out.println(ans);
    }

    public static int findMinimumNumberWithTrailingZeros(int n) {
        int left = 0;
        int right = 5 * n;
        while (left < right) {
            int mid = left + (right - left) / 2; // 오버플로우 방지
            if (countTrailingZeros(mid) < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int countTrailingZeros(int number) {
        int zeroCount = 0;
        while (number >= 5) {
            number /= 5;
            zeroCount += number;
        }
        return zeroCount;
    }
}
