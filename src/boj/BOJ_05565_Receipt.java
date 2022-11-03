package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_05565_Receipt {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());

		int sum = 0;
		int repeat = 9;
		while (repeat-- > 0) {
			sum += Integer.parseInt(br.readLine());
		}

		System.out.println(total - sum);
	}

}
