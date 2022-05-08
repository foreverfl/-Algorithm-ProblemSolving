package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01568_Bird {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int ans = 0;
		int i = 0;
		while (true) {
			if (N <= i)
				i = 0;
			
			ans++;
			i++;

			N = N - i;

			if (N <= 0)
				break;
		}

		System.out.println(ans);
	}

}
