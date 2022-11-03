package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11656_ArrangingSuffix {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String[] arr = new String[S.length()];
		for (int i = 0, j = arr.length - i - 1; i < arr.length; i++, j--) {
			arr[i] = S.substring(j, arr.length);
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}		
		
	}

}
