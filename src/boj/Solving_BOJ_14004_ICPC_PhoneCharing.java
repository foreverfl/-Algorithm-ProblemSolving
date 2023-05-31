package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solving_BOJ_14004_ICPC_PhoneCharing {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double use = Double.parseDouble(st.nextToken());
		double charge = Double.parseDouble(st.nextToken());
		double battery_1 = Double.parseDouble(st.nextToken());
		double battery_2 = Double.parseDouble(st.nextToken());
		double result = 0;

		if (charge == 0) {
			
			result = (battery_1 + battery_2) / use;
			
		} else if (battery_1 == 0) {
			
			result = battery_2 / use;
			
		} else if (battery_2 == 0) {
			
			result = battery_1 / use;
			
		} else {
			// the first process
			double spentSecond_1 = battery_1 / use;
			battery_1 = battery_1 % use;
			battery_2 = battery_2 + spentSecond_1 * charge;

			// the second process
			double spentSecond_2 = battery_2 / use;
			battery_1 = battery_1 + spentSecond_2 * charge;
			battery_2 = battery_2 % use;

			// remains
			double a = battery_1 / use;
			double r = 1 / use;
			double remains = a / (1 - r);

			result = spentSecond_1 + spentSecond_2 + remains;

		}

		System.out.println((int) Math.floor(result));
	}

}
