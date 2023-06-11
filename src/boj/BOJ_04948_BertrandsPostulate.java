package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_04948_BertrandsPostulate {
        public static HashSet<Integer> sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;

        int p = 2;
        while (p * p <= n) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
            p++;
        }

        HashSet<Integer> primes = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static void main(String[] args) throws IOException {
        HashSet<Integer> primes = sieveOfEratosthenes(123456 * 2 + 1);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                break;
            }

            int cnt = 0;
            for (int i = num + 1; i <= 2 * num; i++) {
                if (primes.contains(i)) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
