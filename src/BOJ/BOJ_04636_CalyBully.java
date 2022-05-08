package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_04636_CalyBully {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == -1)
				break;

			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			String taking = "";
			String taken = "";
			while (n-- > 0) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				String name = st.nextToken();

				int size = A * B * C;

				max = Math.max(max, size);
				min = Math.min(min, size);

				if (max == size)
					taking = name;

				if (min == size)
					taken = name;				
			}
			sb.append(taking + " took clay from " + taken + ".").append('\n');

		}
		
		System.out.println(sb.toString());
	}

}
