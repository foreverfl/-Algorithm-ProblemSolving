package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_02828_JABUKE {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int J = Integer.parseInt(br.readLine());

		int left = 1; // left of basket
		int right = M; // right of basket
		int move = 0;
		for (int i = 0; i < J; i++) {
			int where = Integer.parseInt(br.readLine());
			
			if (left <= where && where <= right) {
				continue;
			}
			if (left > where) {
				move += (left - where);
				right -= (left - where);
				left = where;
			} else {
				move += (where - right);
				left += (where - right);
				right = where;
			}
		}
		System.out.println(move);

	}

}

// reference: https://buzz-program.tistory.com/entry/%ED%8C%8C%EC%9D%B4%EC%8D%AC-BOJ2828%EC%82%AC%EA%B3%BC-%EB%8B%B4%EA%B8%B0-%EA%B2%8C%EC%9E%84
