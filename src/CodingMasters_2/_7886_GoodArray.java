package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class _7886_GoodArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean isGood = true;
        loop: for (int i = 0; i < 2 * N; i++) {
            for (int j = i + 1; j < 2 * N; j++) {
                if (arr[i] == arr[j]) { // a_i = a_p
                    for (int k = i + 1; k < j; k++) {
                        for (int l = j + 1; l < 2 * N; l++) {
                            if (arr[k] == arr[l]) { // a_j = a_q
                                isGood = false;
                                break loop;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(isGood ? "YES" : "NO");
    }

}
