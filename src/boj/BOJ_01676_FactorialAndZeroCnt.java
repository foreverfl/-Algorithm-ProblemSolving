package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_01676_FactorialAndZeroCnt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= N; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        String resultStr = result.toString();
        int ans = 0;

        for (int i = resultStr.length() - 1; i >= 0; i--) {
            if (resultStr.charAt(i) == '0') {
                ans++;
            } else {
                break;
            }
        }

        System.out.println(ans);
    }
}
