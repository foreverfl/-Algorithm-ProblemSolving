package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_02287_MonodigitalRepresentations {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int num = 0;

		Set<Integer>[] set = new HashSet[9];
		for (int i = 0; i < 9; i++) {
			set[i] = new HashSet<>();
		}
		// adding continuous numbers
		for (int i = 1; i <= 8; i++) {
			num = 10 * num + K;
			set[i].add(num);
		}

		int kind = 0;
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= i; j++) {
				kind = i + j;
				
				if (kind > 8)
					continue;
				
				for (int y : set[i]) {
					for (int x : set[j]) {
						
						set[kind].add(x + y);
						
						if (x != y) // excluding 0
							set[kind].add(Math.abs(x - y));
						
						set[kind].add(x * y);
						
						if (y > x) // excluding 0
							set[kind].add(y / x);
						else
							set[kind].add(x / y);
					}
				}
			}
		}

		while (T-- > 0) {
			int input = Integer.parseInt(br.readLine());

			int res = -1;
			for (int i = 1; i <= 8; i++) {
				if (set[i].contains(input)) {
					res = i;
					break;
				}
			}

			if (res == -1)
				sb.append("NO").append('\n');
			else
				sb.append(res).append('\n');

		}

		System.out.println(sb.toString());

	}

}

// reference: https://ghdic.github.io/ps/boj-2287/
