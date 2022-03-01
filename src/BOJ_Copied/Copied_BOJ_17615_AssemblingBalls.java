package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_17615_AssemblingBalls {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		char lastColor = str.charAt(N - 1);
		int red = 0;
		int blue = 0;		
		boolean flag = false;
		for (int i = str.length() - 2; i >= 0; i--) {
			if (lastColor == str.charAt(i) && !flag) {
				continue;
			} else {
				flag = true;
				if (str.charAt(i) == 'R')
					red++;
				else
					blue++;
			}
		}
		
		int result_1 = Math.min(red, blue);
		
		red = 0;
		blue = 0;
		flag = false;
		char firstColor = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			if (firstColor == str.charAt(i) && !flag) {
				continue;
			} else {
				flag = true;
				if (str.charAt(i) == 'R')
					red++;
				else
					blue++;
			}
		}
		int result_2 = Math.min(red, blue);
		
		System.out.println(Math.min(result_1, result_2));
	}
}

// reference: https://moons-memo.tistory.com/52