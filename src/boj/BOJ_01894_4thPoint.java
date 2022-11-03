package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01894_4thPoint {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		double[] a = new double[2]; // the farthest apex
		double[] b = new double[2];
		double[] c = new double[2];
		double[] d = new double[2]; // the apex to find

		String str = "";
		while ((str = br.readLine()) != null) {
			
			st = new StringTokenizer(str);
			// side A
			double a_start_x = Double.parseDouble(st.nextToken());
			double a_start_y = Double.parseDouble(st.nextToken());
			double a_end_x = Double.parseDouble(st.nextToken());
			double a_end_y = Double.parseDouble(st.nextToken());

			// side B
			double b_start_x = Double.parseDouble(st.nextToken());
			double b_start_y = Double.parseDouble(st.nextToken());
			double b_end_x = Double.parseDouble(st.nextToken());
			double b_end_y = Double.parseDouble(st.nextToken());

			if (a_start_x == b_start_x && a_start_y == b_start_y) {
				a[0] = a_start_x;
				a[1] = a_start_y;

				b[0] = a_end_x;
				b[1] = a_end_y;
				c[0] = b_end_x;
				c[1] = b_end_y;

			} else if (a_start_x == b_end_x && a_start_y == b_end_y) {
				a[0] = a_start_x;
				a[1] = a_start_y;

				b[0] = a_end_x;
				b[1] = a_end_y;
				c[0] = b_start_x;
				c[1] = b_start_y;

			} else if (a_end_x == b_start_x && a_end_y == b_start_y) {
				a[0] = a_end_x;
				a[1] = a_end_y;

				b[0] = a_start_x;
				b[1] = a_start_y;
				c[0] = b_end_x;
				c[1] = b_end_y;

			} else if (a_end_x == b_end_x && a_end_y == b_end_y) {
				a[0] = a_end_x;
				a[1] = a_end_y;

				b[0] = a_start_x;
				b[1] = a_start_y;
				c[0] = b_start_x;
				c[1] = b_start_y;

			}

			d[0] = b[0] + c[0] - a[0];
			d[1] = b[1] + c[1] - a[1];

			String result_x = String.format("%.3f", d[0]);
			String result_y = String.format("%.3f", d[1]);

			sb.append(result_x + " " + result_y).append('\n');
		}

		System.out.println(sb.toString());
	}

}
