package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10821_TheNumberOfIntegers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		StringTokenizer st = new StringTokenizer(S, ",");

		int cnt = st.countTokens();
		
		System.out.println(cnt);
	}

}
