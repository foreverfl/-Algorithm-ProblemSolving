package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solving_BOJ_05696_CountingNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String str = br.readLine();
			if (str.equals("0 0"))
				break;

			StringTokenizer st = new StringTokenizer(str);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int[] A_arr = countNumber(A - 1);
			int[] B_arr = countNumber(B);

			for (int i = 0; i < 10; i++) {
				sb.append((B_arr[i] - A_arr[i]) + " ");
			}
			sb.append('\n');
		}

		System.out.println(sb.toString());
	}

	private static int[] countNumber(int num) {
		int[] result = new int[10];
		for (int i = 1; i <= num; i *= 10) {
			for (int j = 0; j < 10; j++) {
				if (j < (num / i) % 10)
					result[j] += (num / (i * 10) + 1) * i;
				else if (j == (num / i) % 10)
					result[j] += (num / (i * 10)) * i + (num % i) + 1;
				else
					result[j] += (num / (i * 10)) * i;
			}
			result[0] -= i;
		}
		return result;
	}

}

// reference: https://purealgo.tistory.com/47
