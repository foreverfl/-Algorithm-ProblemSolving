package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class BOJ_04238_Humidex {

	/*
	 * T/D/H를 알아야한다.
	 * T/D를 알고있는 경우
	 * H = ...
	 * 
	 * T/H를 알고있는 경우
	 * D = ...
	 * 
	 * D/H를 알고있는 경우
	 * T = ...
	 * 
	 */

	private static double T, D, H;
	private static String[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		DecimalFormat df = new DecimalFormat("0.0");

		while (true) {
			T = D = H = 0.0;
			String str = br.readLine();
			if (str.equals("E")) {
				break;
			}

			input = new String[4];
			input = str.split(" ");
			if (input[0].equals("T")) {
				T = Double.parseDouble(input[1]);
				if (input[2].equals("D")) {
					D = Double.parseDouble(input[3]);
				} else if (input[2].equals("H")) {
					H = Double.parseDouble(input[3]);
				}

			} else if (input[0].equals("D")) {
				D = Double.parseDouble(input[1]);
				if (input[2].equals("T")) {
					T = Double.parseDouble(input[3]);
				} else if (input[2].equals("H")) {
					H = Double.parseDouble(input[3]);
				}
			} else if (input[0].equals("H")) {
				H = Double.parseDouble(input[1]);
				if (input[2].equals("T")) {
					T = Double.parseDouble(input[3]);
				} else if (input[2].equals("D")) {
					D = Double.parseDouble(input[3]);
				}
			}

			if (T == 0.0) {
				T = H - 0.5555 * (6.11 * Math.exp(5417.7530 * (1 / 273.16 - 1 / (D + 273.16))) - 10);
				T = Double.parseDouble(df.format(T));
			} else if (D == 0.0) {
				D = 1 / ((1 / 273.16) - ((Math.log((((H - T) / 0.5555) + 10.0) / 6.11)) / 5417.7530)) - 273.16;
				D = Double.parseDouble(df.format(D));
			} else if (H == 0.0) {
				H = T + 0.5555 * (6.11 * Math.exp(5417.7530 * (1 / 273.16 - 1 / (D + 273.16))) - 10);
				H = Double.parseDouble(df.format(H));
			}

			sb.append("T " + T + " ");
			sb.append("D " + D + " ");
			sb.append("H " + H + "\n");
		}

		System.out.println(sb.toString());

	}
}
