package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class abc340_E_Mancala2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] A = new int[N];
        int[] B = new int[M];

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < M; i++) {
            int balls = A[B[i]];
            A[B[i]] = 0;
            int C = 0;
            while (balls > 0) {
                C++;
                int boxIndex = (B[i] + C) % N;
                A[boxIndex]++;
                balls--;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
