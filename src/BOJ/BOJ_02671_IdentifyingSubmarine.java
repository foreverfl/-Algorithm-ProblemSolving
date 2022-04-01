package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02671_IdentifyingSubmarine {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();

		if (str.matches("(100+1+|01)+"))
			sb.append("SUBMARINE").append('\n');
		else
			sb.append("NOISE").append('\n');

		System.out.println(sb.toString());

	}

}
