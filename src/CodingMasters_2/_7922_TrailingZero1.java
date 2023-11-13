package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.stream.Stream;

public class _7922_TrailingZero1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int p = arr[0];
        int n = arr[1];
        BigInteger factorialNum = factorial(n);
        System.out.println(countTrailingZeros(factorialNum, p));
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static int countTrailingZeros(BigInteger number, int base) {
        int zeroCount = 0;

        while (number.mod(new BigInteger(String.valueOf(base))).equals(BigInteger.ZERO)
                && !new BigInteger(String.valueOf(base)).equals(BigInteger.ZERO)) {
            zeroCount++;
            number = number.divide(new BigInteger(String.valueOf(base)));
        }
        return zeroCount;
    }
}
