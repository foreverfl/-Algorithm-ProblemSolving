package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class _7894_AntiMultiplyArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isPossible = false;

        loop: for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                for (int k = 0; k < N; k++) {
                    if (i == k || j == k)
                        continue;
                    for (int l = 0; l < N; l++) {
                        if (i == l || j == l || k == l)
                            continue;
                        if (arr[i] * arr[j] == arr[k] * arr[l]) {
                            isPossible = true;
                            break loop;
                        }
                    }
                }

            }

        }

        System.out.println(isPossible ? "YES" : "NO");

    }
}
