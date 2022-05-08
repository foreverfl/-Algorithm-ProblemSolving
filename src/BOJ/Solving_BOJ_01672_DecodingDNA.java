package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solving_BOJ_01672_DecodingDNA {

	static int N;
	static String str;
	static char A, B, tmp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		str = br.readLine();

		int repeat = N - 1;
		while (repeat-- > 0) {
			A = str.charAt(str.length() - 1);
			B = str.charAt(str.length() - 2);
			tmp = decode(A, B);
			str = str.substring(0, str.length() - 2) + tmp;
		}

		bw.write(str + ' ');
		bw.flush();
		bw.close();
	}

	private static char decode(char A, char B) {
		char result = ' ';

		if (A == 'A') {
			if (B == 'A')
				result = 'A';
			else if (B == 'G')
				result = 'C';
			else if (B == 'C')
				result = 'A';
			else if (B == 'T')
				result = 'G';
		} else if (A == 'G') {
			if (B == 'A')
				result = 'C';
			else if (B == 'G')
				result = 'G';
			else if (B == 'C')
				result = 'T';
			else if (B == 'T')
				result = 'A';
		} else if (A == 'C') {
			if (B == 'A')
				result = 'A';
			else if (B == 'G')
				result = 'T';
			else if (B == 'C')
				result = 'C';
			else if (B == 'T')
				result = 'G';
		} else if (A == 'T') {
			if (B == 'A')
				result = 'G';
			else if (B == 'G')
				result = 'A';
			else if (B == 'C')
				result = 'G';
			else if (B == 'T')
				result = 'T';
		}

		return result;
	}

}
