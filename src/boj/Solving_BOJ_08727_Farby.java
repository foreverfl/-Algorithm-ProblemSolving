package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solving_BOJ_08727_Farby {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		double R = Double.parseDouble(st.nextToken());
		double Y = Double.parseDouble(st.nextToken());
		double B = Double.parseDouble(st.nextToken());

		double[] colors = new double[7];
		for (int i = 1; i <= 6; i++)
			colors[i] = Double.parseDouble(br.readLine()); // Y, G, B, P, R, O

		R -= colors[5];
		Y -= colors[1];
		B -= colors[3];

		// green
		B -= colors[2] / 2;
		Y -= colors[2] / 2;

		// purple
		R -= colors[4] / 2;
		B -= colors[4] / 2;

		// orange
		R -= colors[6] / 2;
		Y -= colors[6] / 2;

		R = (R > 0) ? 0 : R * -1;
		Y = (Y > 0) ? 0 : Y * -1;
		B = (B > 0) ? 0 : B * -1;

		System.out.print(doubleToString(R) + " " + doubleToString(Y) + " " + doubleToString(B));

	}

	private static String doubleToString(double num) {
		long tmp = (long) num;

		if (num - tmp == 0) {
			return String.valueOf(tmp);
		} else {
			return String.valueOf(num);
		}
	}

}
