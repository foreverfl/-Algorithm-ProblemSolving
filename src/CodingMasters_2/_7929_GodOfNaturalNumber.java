package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7929_GodOfNaturalNumber {

    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long N = Long.parseLong(input[0]);
        long K = Long.parseLong(input[1]);

        long oddNumCount;
        long evenNumCount;

        if (N % 2 == 1) {
            oddNumCount = N / 2 + 1;
            evenNumCount = N / 2;
        } else {
            oddNumCount = N / 2;
            evenNumCount = N / 2;
        }

        long res;

        if (K <= oddNumCount) {
            res = K * 2 - 1;
        } else {
            res = (K - oddNumCount) * 2;
        }

        System.out.println(res);
    }
}
