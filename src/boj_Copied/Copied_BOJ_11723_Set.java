package boj_Copied;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Copied_BOJ_11723_Set {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int M = Integer.parseInt(br.readLine());
		int bitset = 0;
		String tmp = ""; // for checking

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String operation = st.nextToken();
			int num;
			
			switch (operation) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				bitset |= (1 << (num - 1)); // This is the 'num - 1' because it starts from '0'.
				
				tmp = Integer.toBinaryString(bitset);
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				bitset = bitset & ~(1 << (num - 1));
				
				tmp = Integer.toBinaryString(bitset);
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				sb.append((bitset & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
				
				tmp = Integer.toBinaryString(bitset);
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				bitset ^= (1 << (num - 1));
				
				tmp = Integer.toBinaryString(bitset);
				break;
			case "all":
				bitset |= (~0);
				
				tmp = Integer.toBinaryString(bitset);
				break;
			case "empty":
				bitset &= 0;
				
				tmp = Integer.toBinaryString(bitset);
				break;
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}

// reference: https://dragon-h.tistory.com/28
