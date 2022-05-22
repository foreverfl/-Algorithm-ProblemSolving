package BOJ_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_10219_MeatsOnTheGrill {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] arr = new char[H][W];

			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			for (int i = 0; i < H; i++) {
				for (int j = W - 1; j >= 0; j--) {
					System.out.print(arr[i][j]);
				}
				System.out.print("\n");
			}

		}
	}

}

// reference: https://blue-boy.tistory.com/159