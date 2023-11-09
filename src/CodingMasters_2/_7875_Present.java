package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class _7875_Present {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] presents = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int minStudent = Arrays.stream(presents).min().getAsInt();

        int max = Integer.MIN_VALUE;
        loop: for (int i = 1; i <= minStudent; i++) {
            for (int j = 0; j < N; j++) {
                if (presents[j] % i != 0) {
                    continue loop;
                }
            }
            int res = i;
            max = Math.max(max, res);
        }

        System.out.print(max);
    }
}
