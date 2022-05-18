package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_19939_BurstingGourd {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int prevSum = getArithmeticSequenceSum(1, K, K);
		if (N < prevSum) {
			System.out.println(-1);
			return;
		}
		
		int i = 2;
		while (true) {
			int curSum = getArithmeticSequenceSum(i, K + i - 1, K);
			if (curSum > N) {
				if (prevSum == N)
					System.out.println(K - 1);
				else
					System.out.println(K);
				return;
			}
			prevSum = curSum;
			i++;
		}
	}

	private static int getArithmeticSequenceSum(int s, int e, int k) {
		return (s + e) * k / 2;
	}
}

// reference: https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-19939-%EB%B0%95-%ED%84%B0%EB%9C%A8%EB%A6%AC%EA%B8%B0-boj-java