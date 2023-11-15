package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solving_7891_CardGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cards = new int[N + 1];
        int[] cardSum = new int[N + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(input[i - 1]);
            cardSum[i] = cardSum[i - 1] + cards[i];
        }

        System.out.println(Arrays.toString(cards));

        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = cards[i];
            if (i > 1) {
                dp[i] = Math.max(dp[i], cardSum[i] - dp[i - 1]);
            }
            if (i > 2) {
                dp[i] = Math.max(dp[i], cardSum[i] - dp[i - 2]);
            }
            if (i > 3) {
                dp[i] = Math.max(dp[i], cardSum[i] - dp[i - 3]);
            }
        }

        System.out.println(dp[N]);

    }
}
