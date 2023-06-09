package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_10986_SumOfRest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] cnt = new long[1001];
        long sum = 0;
        long ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            sum += x;
            cnt[(int)(sum % M)]++;
        }

        for (int i = 0; i <= 1000; i++) {
            ans += cnt[i] * (cnt[i] - 1) / 2;
        }

        System.out.println(cnt[0] + ans);

        br.close();
    }
}

// reference: https://cocoon1787.tistory.com/396
