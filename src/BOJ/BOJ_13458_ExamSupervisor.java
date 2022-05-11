package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458_ExamSupervisor {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int A = Integer.parseInt(br.readLine());
		long[] arr = new long[A];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long[] res = new long[A];
		for (int i = 0; i < A; i++) {
			// main
			arr[i] -= B;
			res[i]++;

			if(arr[i] <= 0)
				continue;
			
			// vice
			if (arr[i] % C == 0)
				res[i] += arr[i] / C;
			else
				res[i] += (arr[i] / C + 1);
		}

		long ans = 0;
		for (int i = 0; i < A; i++) {
			ans += res[i];
		}

		System.out.println(ans);
	}

}
