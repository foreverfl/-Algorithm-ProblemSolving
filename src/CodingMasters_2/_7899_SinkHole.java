package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class _7899_SinkHole {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] holes = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(holes);

        int ans = 0;
        int i = 0;
        while (i < N) {
            int start = holes[i];
            while (i < N && holes[i] - start < K) {
                i++;
            }
            ans++;
        }

        System.out.println(ans);
    }

}
