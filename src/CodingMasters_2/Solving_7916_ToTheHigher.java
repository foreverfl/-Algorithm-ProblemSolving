package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solving_7916_ToTheHigher {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int maxJump = 1;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (heights[j] < heights[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxJump = Math.max(maxJump, dp[i]);
        }

        System.out.println(maxJump);

    }
}
