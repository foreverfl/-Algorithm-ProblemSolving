package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01297_TVSize {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int H_ratio = Integer.parseInt(st.nextToken());
		int W_ratio = Integer.parseInt(st.nextToken());

		double D_ratio = Math.sqrt((Math.pow(H_ratio, 2) + Math.pow(W_ratio, 2)));

		double H = D * H_ratio / D_ratio;
		double W = D * W_ratio / D_ratio;

		System.out.println((int) Math.floor(H) + " " + (int) Math.floor(W));

	}

}
