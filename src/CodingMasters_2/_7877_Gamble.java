package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class _7877_Gamble {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] cups = IntStream.rangeClosed(1, N).toArray();
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            cups = mixCups(cups, Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1);

        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (cups[i] == K) {
                System.out.println(i + 1);
                break;
            }
        }
    }

    public static int[] mixCups(int[] cups, int A, int B) {
        int tmp = cups[B];
        cups[B] = cups[A];
        cups[A] = tmp;
        return cups;
    }
}
