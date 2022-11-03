package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15736_BlugFlagWhiteFlag {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		int W = 0;
		int B = 0;
		int tmp = 2;
		while (true) {
			W++;
			B = B + tmp;
			tmp += 2;

			if (W + B >= num)
				break;
		}

		System.out.println(W);

	}

}
