package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14754_PizzaBoxes {

	static long[][] input, box;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		input = new long[n][m];
		box = new long[n][m];

		long total = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				total += input[i][j];
			}
		}

		long max = Integer.MIN_VALUE;
		int max_x = 0;
		int max_y = 0;
		
		// front
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (input[i][j] > max) {
					max = input[i][j];
					max_x = i;
					max_y = j;
				}
			}
			box[max_x][max_y] = max;
			max = Integer.MIN_VALUE;
			max_x = 0;
			max_y = 0;
		}

		// side
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (input[j][i] > max) {
					max = input[j][i];
					max_x = j;
					max_y = i;
				}
			}
			box[max_x][max_y] = max;
			max = Integer.MIN_VALUE;
			max_x = 0;
			max_y = 0;
		}
		
		long remove = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				remove += box[i][j];
			}			
		}
		
		System.out.println(total - remove);
		
		

	}

}
