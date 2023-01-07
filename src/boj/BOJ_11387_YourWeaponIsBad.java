package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11387_YourWeaponIsBad {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		double[][] arr = new double[4][5];

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		double[] cri_me = new double[5];
		for (int i = 0; i < 5; i++) {
			cri_me[i] = arr[0][i];
		}
		double[] cri_other = new double[5];
		for (int i = 0; i < 5; i++) {
			cri_other[i] = arr[0][i] - arr[2][i] + arr[3][i];
		}

		double[] paboo_me = new double[5];
		for (int i = 0; i < 5; i++) {
			paboo_me[i] = arr[1][i];
		}
		double[] paboo_other = new double[5];
		for (int i = 0; i < 5; i++) {
			paboo_other[i] = arr[1][i] - arr[3][i] + arr[2][i];
		}

		double cri_me_power = calcPower(cri_me);
		double cri_other_power = calcPower(cri_other);
		double paboo_me_power = calcPower(paboo_me);
		double paboo_other_power = calcPower(paboo_other);

		sb.append(check(cri_me_power, cri_other_power)).append('\n');
		sb.append(check(paboo_me_power, paboo_other_power));

		System.out.println(sb.toString());
	}

	private static double calcPower(double[] arr) {
		double ans = arr[0] * (100 + arr[1]) * (100 * (100 - Math.min(arr[2], 100)) + Math.min(arr[2], 100) * arr[3])
				* (100 + arr[4]);

		return ans;
	}

	private static String check(double a, double b) {
		if (a > b) {
			return "-";
		} else if (a < b) {
			return "+";
		} else {
			return "0";
		}
	}

}
