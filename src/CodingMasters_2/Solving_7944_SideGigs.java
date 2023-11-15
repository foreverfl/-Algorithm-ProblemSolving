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
            int a2 = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            int b1 = Integer.parseInt(input[0]);
            int b2 = Integer.parseInt(input[1]);

            sb.append(isPossible(a, b, a1, b1, a2, b2) ? "YES" : "NO").append('\n');

        }

        System.out.println(sb.toString().trim());
    }

    public static boolean isPossible(int N, int K, int a1, int b1, int a2, int b2) {
        for (int i = 0, j = 0; i <= N || j <= K; i = i + a1, j = j + b1) {
            for (int k = 0, l = 0; k <= N || l <= K; k = k + a2, l = l + b2) {
                if (i + k == N && j + l == K) {
                    return true;
                }
            }
        }

        return false;
    }
}
