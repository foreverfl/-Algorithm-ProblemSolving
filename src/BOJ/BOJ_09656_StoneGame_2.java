package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_09656_StoneGame_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[1001];

		arr[1] = 1;
		arr[2] = 2;

		int num = 1;
		int check = 0;
		for (int i = 3; i < 1000; i++) {
			arr[i] = num;
			num++;
			check++;

			if (check == 3) {
				num = num - 2;
				check = 0;
			}
		}

		if (arr[N] % 2 == 0)
			System.out.println("SK");
		else
			System.out.println("CY");
	}

}
