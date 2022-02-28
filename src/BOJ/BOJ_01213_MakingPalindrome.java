package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01213_MakingPalindrome {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		int[] alpha = new int[26];
		
		for(char ch : str.toCharArray()) {
			alpha[ch - 'A']++;
		}
		
		int n = 0, mid = 0;
		
		for(int i = 0; i < 26; i++) {
			if(alpha[i] % 2 == 1) {
				mid = i;
				n++;
			}
		}
		
		
		if((str.length() % 2 == 1 && n > 1) || (str.length() % 2 == 0 && n > 0)) {
			sb.append("I'm Sorry Hansoo");
		}
		
		else {
			
			String answer = "";
			for(int i = 0; i < 26; i++) {
				for(int j = 0; j < alpha[i] / 2; j++) {
					answer += (char)(i + 'A');
				}
			}
			
			String rev = new StringBuilder(answer).reverse().toString();
			if(n == 1) {
				answer += (char)(mid + 'A');
			}
			
			sb.append(answer + rev);
		}
		System.out.print(sb);
	}
}


// reference: https://lms0806.tistory.com/66