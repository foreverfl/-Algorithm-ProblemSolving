package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7920_InvestingInStocks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        System.out.println(countProfitCases(N, K));
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long combination(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static long countProfitCases(int N, int K) {
        // 100 x u - 100 x d = K
        // 100 x u - 100 (N - u) = K -> u + d = N
        // 100u - 100N + 100u = K
        // 200u = K + 100N
        // u = ( K + 100N ) / 200
        int upCount = (K / 100 + N) / 2; // K는 항상 100의 배수이므로 위에서 아래의 공식이 도출됨

        if ((K + 100 * N) % 200 != 0) {
            return 0;
        }

        if (upCount > N || upCount < 0) {
            return 0;
        }

        return combination(N, upCount);
    }
}
