package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02953_PET {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] arr = new int[5][5]; // 마지막 샆은 앞 4개의 합
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			arr[i][3] = Integer.parseInt(st.nextToken());

			for (int j = 0; j < 4; j++) {
				arr[i][4] += arr[i][j];
			}

			if (arr[i][4] > max)
				max = arr[i][4];
		}

		for (int i = 0; i < 5; i++) {
			if (max == arr[i][4])
				System.out.println((i + 1) + " " + arr[i][4]);
		}
	}

}
