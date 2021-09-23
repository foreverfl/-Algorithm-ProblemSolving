package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _543 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		for (int i = 1; i <= input; i++) {
			if(i%2 == 0) {
				System.out.print(i + " ");
			}
		}

	}

}
