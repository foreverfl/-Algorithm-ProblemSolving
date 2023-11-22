package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solving_7951_ObservingInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(countNumbers(a));
    }

    public static BigInteger countNumbers(int[] a) {
        BigInteger result = BigInteger.ZERO;
        int n = a.length;
        BigInteger billion = BigInteger.valueOf(1000000000);

        for (int i = 1; i < (1 << n); i++) {
            BigInteger lcm = BigInteger.ONE;
            int bitCount = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    lcm = lcm(lcm, BigInteger.valueOf(a[j]));
                    bitCount++;
                }
            }

            BigInteger tempResult = billion.divide(lcm);
            if (bitCount % 2 == 1) {
                result = result.add(tempResult);
            } else {
                result = result.subtract(tempResult);
            }
        }

        return result;
    }

    public static BigInteger lcm(BigInteger a, BigInteger b) {
        return (a.divide(a.gcd(b))).multiply(b);
    }
}
