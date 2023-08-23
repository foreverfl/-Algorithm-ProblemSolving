package CodingMasters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7174_Coupon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] units = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

        int ans = 0;
        for (int unit : units) {
            ans += N / unit;
            N %= unit;
        }

        System.out.println(ans);
    }
}
