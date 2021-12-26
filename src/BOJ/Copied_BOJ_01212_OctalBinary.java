package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Copied_BOJ_01212_OctalBinary {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		StringBuilder sb = new StringBuilder();

		for (int i = input.length() - 1; i >= 0; i--) {
			int num = input.charAt(i) - '0'; // string → integer
			
			if (input.length() == 1 && num == 0) { // in case of '0'
				sb.append(0);
				break;
			}
			
			int count = 0;
			while (num > 0) {
				count++;
				sb.append(num % 2);
				num /= 2;
			}

			if (i == 0)
				break;
			sb.append("0".repeat(Math.max(0, 3 - count))); // appending "0"

		}
		System.out.println(sb.reverse().toString());
	}

}

// reference: https://blog.naver.com/PostView.nhn?blogId=ajy7424&logNo=222513679738