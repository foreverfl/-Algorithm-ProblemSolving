package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02857_AVION {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = new String[5];
		int[] arr_cnt = new int[5];
		boolean flag = false;

		for (int i = 0; i < 5; i++) {
			arr_cnt[i] = i + 1;
		}

		for (int i = 0; i < 5; i++) {
			arr[i] = br.readLine();
		}

		for (int i = 0; i < 5; i++) {
			if (arr[i].contains("FBI")) {
				System.out.print(arr_cnt[i] + " ");
				flag = true;
			}
		}
		
		if(!flag) 
			System.out.println("HE GOT AWAY!");

	}

}
