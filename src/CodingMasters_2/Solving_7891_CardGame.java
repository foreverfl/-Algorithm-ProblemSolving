package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solving_7891_CardGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cards = new int[N + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(input[i - 1]);
        }

        int[][] dp = new int[N + 1][2]; // 철수가 얻은 최대 점수 및 영희가 얻은 최소 점수

        // N이 1 ~ 3까지는 직접 계산
        dp[1][0] = cards[1];
        dp[2][0] = cards[1] + cards[2];
        dp[3][0] = cards[1] + cards[2] + cards[3];

        // N이 4 이상일 때
        for (int i = 4; i <= N; i++) {
            // i 선택
            int a1 = cards[i] + dp[i - 2][0]; // 철수
            int b1 = cards[i - 1] + dp[i - 3][1]; // 영희
            // i / i - 1 선택
            int a2 = cards[i] + dp[i - 3][0];
            int b2 = cards[i - 2] + dp[i - 4][1];
            // i / i - 1 / i - 2 선택
            int a3 = cards[i] + cards[i - 1] + cards[i - 2] + dp[i - 4][0];
            int b3;
            if (i == 4) {
                b3 = cards[i - 3];
            } else {
                b3 = cards[i - 3] + dp[i - 5][1];
            }

            int max = Math.max(a1, Math.max(a2, a3));
            if (max == a1) {
                dp[i][0] = a1;
                dp[i][1] = b1;
            } else if (max == a2) {
                dp[i][0] = a2;
                dp[i][1] = b2;
            } else if (max == a3) {
                dp[i][0] = a3;
                dp[i][1] = b3;
            }
        }

        System.out.println(dp[N][0] - dp[N][1]);

    }
}
