package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02804_MakingCrosswords {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();

		char common = ' ';
		loop: for (int i = 0; i < A.length(); i++) {
			for (int j = 0; j < B.length(); j++) {
				if (A.charAt(i) == B.charAt(j)) {
					common = A.charAt(i);
					break loop;
				}
			}
		}

		char[][] map = new char[B.length()][A.length()];

		int horizontal = A.indexOf(common);
		int vertical = B.indexOf(common);
		
		// initialization
		for (int i = 0; i < B.length(); i++) {
			for (int j = 0; j < A.length(); j++) {
				map[i][j] = '.';
			}
		}	

		for (int i = 0; i < B.length(); i++) {
			for (int j = 0; j < A.length(); j++) {
				map[i][horizontal] = B.charAt(i);
				map[vertical][j] = A.charAt(j);
			}
		}

		for (int i = 0; i < B.length(); i++) {
			for (int j = 0; j < A.length(); j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

}
