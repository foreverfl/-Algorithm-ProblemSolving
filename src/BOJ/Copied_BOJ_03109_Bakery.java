package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_03109_Bakery {

	static char[][] map;
	static int R;
	static int C;
	static int val;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();

		for (int i = 0; i < R; i++)
			if (check(i, 0))
				val++;
		System.out.println(val);
	}

	public static boolean check(int x, int y) {
		map[x][y] = '-';

		if (y == C - 1) // If the final value is true, either the other values is.
			return true;

		if (x > 0 && map[x - 1][y + 1] == '.') // up-right 
			if (check(x - 1, y + 1))
				return true;
		
		if (map[x][y + 1] == '.') // right
			if (check(x, y + 1))
				return true;
		
		if (x + 1 < R && map[x + 1][y + 1] == '.') // down-right 
			if (check(x + 1, y + 1))
				return true;
		
		return false;
	}
}

// reference: https://wiselog.tistory.com/140
