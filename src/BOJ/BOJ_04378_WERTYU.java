package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_04378_WERTYU {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		while (str != null) {

			String ans = "";
			for (int i = 0; i < str.length(); i++) {
				char tmp_1 = str.charAt(i);
				char tmp_2 = changeChar(tmp_1);
				ans += tmp_2;
			}

			
			sb.append(ans);
			
			if(str != null) 
				sb.append('\n');
			
			str = br.readLine();
		}

		String res = sb.toString();
		bw.write(res);
		bw.flush();
		bw.close();
	}

	private static char changeChar(char cha) {
		char res = ' ';

		String str = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

		for (int i = 1; i < str.length(); i++) {
			if (cha == str.charAt(i))
				res = str.charAt(i - 1);
		}

		return res;
	}
}
