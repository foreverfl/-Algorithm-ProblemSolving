package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7885_RightAngledTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxPerimeter = 0;
        int maxCount = 0;

        for (int p = 12; p <= N; p++) {
            int count = countTriangle(p);
            if (count > maxCount) {
                maxCount = count;
                maxPerimeter = p;
            }
        }

        System.out.println(maxPerimeter + " " + maxCount);
    }

    public static int countTriangle(int N) {
        int count = 0;
        for (int i = 1; i <= N / 3; i++) {
            for (int j = i + 1; j <= N / 2; j++) {
                int k = N - i - j;
                if (i * i + j * j == k * k) {
                    count++;
                }
            }
        }

        return count;

    }
}
