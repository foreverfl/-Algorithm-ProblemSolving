package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10886_NotCuteAndCute {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt_1 = 0;
		int cnt_0 = 0;

		while (N-- > 0) {
			int vote = Integer.parseInt(br.readLine());

			if (vote == 1)
				cnt_1++;
			else
				cnt_0++;
		}
		
		if(cnt_1>cnt_0)
			System.out.println("Junhee is cute!");
		else
			System.out.println("Junhee is not cute!");

	}

}
