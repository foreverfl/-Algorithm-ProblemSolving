package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_05576_Contest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] W = new int[10];
		int[] K = new int[10];

		for (int i = 0; i < 10; i++) {
			W[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < 10; i++) {
			K[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(W);
		Arrays.sort(K);

		int ans_W = 0;
		int ans_K = 0;
		for (int i = 7; i < 10; i++) {
			ans_W += W[i];
			ans_K += K[i];
		}

		System.out.println(ans_W + " " + ans_K);
	}

}
