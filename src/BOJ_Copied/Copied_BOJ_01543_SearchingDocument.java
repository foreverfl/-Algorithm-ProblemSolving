package BOJ_Copied;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Copied_BOJ_01543_SearchingDocument {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String document = br.readLine();
		String keyword = br.readLine();
		int count = 0;
		for (int i = 0; i < document.length() - keyword.length() + 1; i++) {
			String temp = document.substring(i, i + keyword.length());
			if (temp.equals(keyword)) {
				count++;
				i += keyword.length();
				i--;
			}
		}
		bw.write(count + "\n");

		bw.flush();
		br.close();
		bw.close();
	}

}

// reference: https://blog.crazzero.com/m/101