package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20528_WordChainGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		char first = st.nextToken().charAt(0);
		N--;

		boolean flag = true;
		while (N-- > 0) {
			char check = st.nextToken().charAt(0);

			if (first != check)
				flag = false;
		}

		if (flag)
			System.out.println(1);
		else
			System.out.println(0);
	}

}
