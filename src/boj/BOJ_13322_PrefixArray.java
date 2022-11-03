package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13322_PrefixArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			sb.append(i).append('\n');
		}

		System.out.println(sb.toString());
	}

}
