package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7953_SleepingGayeong {

    public static int[] dx = { 1, -1, 0 }; // 위/아래/그대로
    public static int[] probability;
    public static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 아파트의 높이
        int K = Integer.parseInt(input[1]); // 시작 위치
        int A = Integer.parseInt(input[2]);
        int B = Integer.parseInt(input[3]);
        int C = Integer.parseInt(input[4]);
        int X = Integer.parseInt(input[5]); // 시간

        cnt = new int[N + 1];
        probability = new int[] { A, B, C };

        dfs(K, N, 0, X, 1); // 위치, 높이, 현재 시간, 전체 시간, 현재 확률(분자)
        int denominator = (int) Math.pow(A + B + C, X);
        // System.out.println(Arrays.toString(cnt));

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (cnt[i] == 0) {
                sb.append("0/1").append(" ");
            } else {
                int gcd = calcGCD(cnt[i], denominator);
                int numerator_1 = cnt[i] / gcd;
                int denominator_1 = denominator / gcd;
                sb.append(numerator_1 + "/" + denominator_1).append(" ");
            }

        }
        sb.append('\n');

        int sum = Arrays.stream(cnt).sum();
        if (sum == 0) {
            sb.append("0/1").append(" ");
        } else {
            int escape_numerator = denominator - sum;
            int escape_gcd = calcGCD(escape_numerator, denominator);
            int numerator_2 = escape_numerator / escape_gcd;
            int denominator_2 = denominator / escape_gcd;
            sb.append(numerator_2 + "/" + denominator_2);
        }

        System.out.println(sb.toString());

    }

    public static void dfs(int pos, int height, int time_now, int time, int probability_now) {
        // 움직임이 끝나고, 1층이나 N층에 도착했을 때
        if (time_now == time) {
            cnt[pos] += probability_now;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nx = pos + dx[i];

            if (nx < 1 || nx > height) {
                continue; // 잠에서 깸
            }

            dfs(nx, height, time_now + 1, time, probability_now * probability[i]);

        }
    }

    public static int calcGCD(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        if (a % b == 0) {
            return b;
        }
        return calcGCD(b, a % b);
    }
}
