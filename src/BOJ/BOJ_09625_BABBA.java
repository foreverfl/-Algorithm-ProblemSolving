package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_09625_BABBA {

	static class AB {
		int A;
		int B;

		AB(int A, int B) {
			this.A = A;
			this.B = B;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		AB[] dp = new AB[45 + 1];

		dp[1] = new AB(0, 1);
		dp[2] = new AB(1, 1);

		for (int i = 3; i <= 45; i++) {
			int A = dp[i - 1].A + dp[i - 2].A;
			int B = dp[i - 1].B + dp[i - 2].B;
			dp[i] = new AB(A, B);
		}

		System.out.print(dp[K].A + " " + dp[K].B);
	}

}
