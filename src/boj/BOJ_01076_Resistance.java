package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01076_Resistance {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] color = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };
		String[] value = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		long[] multiplication = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };

		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();

		String tmp_1 = "";

		for (int i = 0; i < 10; i++) {
			if (a.equals(color[i])) {
				tmp_1 += value[i];
			}
	
		}

		for (int i = 0; i < 10; i++) {
			if (b.equals(color[i])) {
				tmp_1 += value[i];
			}	
		}
		
		long tmp_2 = 0L;

		for (int i = 0; i < 10; i++) {
			if (c.equals(color[i])) {
				tmp_2 = multiplication[i];
			}
		}

		long result = Integer.parseInt(tmp_1) * tmp_2;

		System.out.println(result);

	}
}
