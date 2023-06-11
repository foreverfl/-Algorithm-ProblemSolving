package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_09020_GoldbachsConjecture {
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
        HashSet<Integer> primes = sieveOfEratosthenes(10000);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] partition = {0, 10000};
            int diff = 0;

            for (int i = 0; i < n; i++) {
                if (primes.contains(i) && primes.contains(n - i)) {
                    int a = Math.max(i, n - i);
                    int b = Math.min(i, n - i);
                    diff = a - b;
                    if (partition[1] - partition[0] > diff) {
                        partition[0] = b;
                        partition[1] = a;
                    }
                }
            }

            System.out.println(partition[0] + " " + partition[1]);
        }
    }
}
