package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_21758_ObtainingHoney {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];

		String[] tmp = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(tmp[i - 1]);
            sum[i] = arr[i] + sum[i - 1];
        }

        int ans = 0;
        for (int i = 2; i < N; i++) { // 벌, 벌, 꿀통
            ans = Math.max(ans, (sum[N] - arr[1] - arr[i]) + (sum[N] - sum[i]));
        }

        for (int i = 2; i < N; i++) { // 꿀통, 벌, 벌
            ans = Math.max(ans, sum[i - 1] + (sum[N] - arr[N] - arr[i]));
        }

        for (int i = 2; i < N; i++) { // 벌, 꿀통, 벌
            ans = Math.max(ans, (sum[i] - arr[1]) + (sum[N] - sum[i - 1] - arr[N]));
        }

        System.out.println(ans);
		


	}
}

// reference: https://david0506.tistory.com/68