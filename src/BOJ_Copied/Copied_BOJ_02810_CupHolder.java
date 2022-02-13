package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_02810_CupHolder {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int cnt = 1;
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == 'S')
				cnt++;

			else if (str.charAt(i) == 'L') {
				i++;
				cnt++;
			}
		}

		if (cnt > N)
			System.out.println(N);
		else
			System.out.println(cnt);
	}
}

// reference: https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-2810%EB%B2%88-%EC%BB%B5%ED%99%80%EB%8D%94-%EC%9E%90%EB%B0%94Java