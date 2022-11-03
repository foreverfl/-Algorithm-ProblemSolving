package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_05586_JOIAndIOI {

	static final String IOI = "IOI";
	static final String JOI = "JOI";
	static int IOI_cnt = 0;
	static int JOI_cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String check = "";
		for (int i = 0; i < str.length() - 2; i++) {
			check = str.substring(i, i + 3);
			if (check.equals(IOI))
				IOI_cnt++;
			if (check.equals(JOI))
				JOI_cnt++;
		}

		System.out.println(JOI_cnt);
		System.out.println(IOI_cnt);		
	}

}
