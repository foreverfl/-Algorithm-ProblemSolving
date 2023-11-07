package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solving_7944_SideGigs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            int a1 = Integer.parseInt(input[0]);
            int b1 = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            int a2 = Integer.parseInt(input[0]);
            int b2 = Integer.parseInt(input[1]);

            sb.append(isPossible(a, b, a1, b1, a2, b2) ? "YES" : "NO").append('\n');

        }

        System.out.println(sb.toString());
    }

    public static boolean isPossible(int N, int K, int a1, int a2, int b1, int b2) {
        // a1 또는 b1이 0일 때, 곰인형 N을 정확히 넣을 수 있는지 확인
        if ((a1 == 0 && N % b1 != 0) || (b1 == 0 && N % a1 != 0))
            return false;
        // a2 또는 b2가 0일 때, 로봇 K를 정확히 넣을 수 있는지 확인
        if ((a2 == 0 && K % b2 != 0) || (b2 == 0 && K % a2 != 0))
            return false;

        // 모든 경우의 수를 확인합니다.
        for (int x = 0; x <= N; x += (a1 == 0 ? 1 : a1)) {
            int y = N - x;
            // a1 또는 b1이 0이 아니면 해당 값으로 나누어 떨어지는지 확인
            if ((a1 == 0 || x % a1 == 0) && (b1 == 0 || y % b1 == 0)) {
                int ka = (a1 == 0 ? 0 : x / a1) * a2;
                int kb = (b1 == 0 ? 0 : y / b1) * b2;
                if (ka + kb == K)
                    return true;
            }
        }

        return false;
    }
}
