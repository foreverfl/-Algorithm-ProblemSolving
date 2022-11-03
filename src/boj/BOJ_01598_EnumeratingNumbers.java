package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01598_EnumeratingNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int tmp_1 = 0;
		int tmp_2 = 0;

		tmp_1 = A / 4;
		tmp_2 = B / 4;

		if (A % 4 == 0)
			tmp_1--;
		if (B % 4 == 0)
			tmp_2--;

		int horizontal = Math.abs(tmp_1 - tmp_2);

		tmp_1 = A % 4;
		tmp_2 = B % 4;
		
		if (A % 4 == 0)
			tmp_1 = 4;
		if (B % 4 == 0)
			tmp_2 = 4;
		
		int vertical = Math.abs((tmp_1 - tmp_2));
		int result = horizontal + vertical;

		System.out.println(result);
	}

}
