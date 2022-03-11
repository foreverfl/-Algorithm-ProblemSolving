package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11944_NN {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		String N = st.nextToken();
		int N_number = Integer.parseInt(N);
		int M = Integer.parseInt(st.nextToken());

		int repeat = N_number;
		String result = "";
		while (repeat-- > 0) {
			result += N;
		}

		if (N_number < M) {
			System.out.println(result);
		} else {
			System.out.println(result.substring(0, M));
		}

	}

}
