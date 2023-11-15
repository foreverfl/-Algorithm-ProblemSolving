package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class _7902_CountingPrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int num = 0;
        int idx = 0;
        loop: while (true) {
            num++;
            if (isPrime(num)) {
                String numStr = String.valueOf(num);
                for (int i = 0; i < numStr.length(); i++) {
                    char c = numStr.charAt(i);
                    int digit = Character.getNumericValue(c);
                    if (digit == arr[idx]) {
                        idx++;
                        if (idx == K) {
                            break loop;
                        }
                    }
                }
            }
        }

        System.out.println(num);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
