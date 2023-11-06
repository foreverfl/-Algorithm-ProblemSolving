package CodingMasters_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class _7182_IsPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(countPrime(N));

    }

    public static int countPrime(int num) {
        boolean[] isPrime = new boolean[num + 1];
        Arrays.fill(isPrime, true);

        if (num < 2) {
            return 0;
        }

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(num); i++) {

            if (isPrime[i] == false) {
                continue;
            }

            for (int j = i * i; j < isPrime.length; j = j + i) {
                isPrime[j] = false;
            }
        }

        return (int) IntStream.range(0, isPrime.length).filter(i -> isPrime[i]).count();
    }
}
