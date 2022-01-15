package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_07795_EatOrBeEaten {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// reading the second and fifth line but doing nothing
			int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			int count = 0;
			for (int i : A)
				for (int j : B) {
					if (i <= j)
						break;
					else
						count++;
				}
			sb.append(count + "\n");
		}
		System.out.print(sb);
	}
}

// reference: https://dalconbox.tistory.com/176
