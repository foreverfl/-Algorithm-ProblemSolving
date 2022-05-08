package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_05543_Lunch {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] burger = new int[3];
		int[] drink = new int[2];

		int result = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++) {
			burger[i] = Integer.parseInt(br.readLine());
			min = Math.min(burger[i], min);
		}

		result += min;
		min = Integer.MAX_VALUE;

		for (int i = 0; i < 2; i++) {
			drink[i] = Integer.parseInt(br.readLine());
			min = Math.min(drink[i], min);
		}

		result += min;
		System.out.println(result - 50);
	}

}
