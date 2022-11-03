package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10173_FindingNemo {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String str = br.readLine();
			if (str.equals("EOI"))
				break;

			String tmp = str.toLowerCase();
			if (tmp.contains("nemo"))
				sb.append("Found").append('\n');
			else
				sb.append("Missing").append('\n');
		}

		System.out.println(sb.toString());
	}

}
