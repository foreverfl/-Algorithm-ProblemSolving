package CodingMasters_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _7253_CousinNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] nums = new Integer[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums, Collections.reverseOrder());

        // 차이 구하기
        int[] diff = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diff[i] = nums[i] - nums[i + 1];
        }

        // 차이들의 최대공약수 구하기
        int gcd = diff[0];
        for (int i = 1; i < N - 1; i++) {
            gcd = calcGCD(gcd, diff[i]);
        }

        // 약수 찾기
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(gcd); i++) {
            if (gcd % i == 0) {
                divisors.add(i);
                if (i != gcd / i) {
                    divisors.add(gcd / i);
                }
            }
        }

        // 약수를 정렬하고 출력
        Collections.sort(divisors);
        for (int num : divisors) {
            System.out.print(num + " ");
        }

    }

    public static int calcGCD(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        return (b == 0) ? a : calcGCD(b, a % b);
    }
}
