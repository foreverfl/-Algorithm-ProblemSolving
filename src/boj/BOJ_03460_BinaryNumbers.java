package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_03460_BinaryNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int num = Integer.parseInt(br.readLine());
			String binaryNum = Integer.toBinaryString(num);
			for (int i = binaryNum.length() - 1; i >= 0; i--) {
				if (binaryNum.charAt(i) == '1') {
					sb.append((binaryNum.length() - 1 - i) + " ");
				}
			}
			sb.append('\n');
		}

		System.out.print(sb.toString());
	}

}
