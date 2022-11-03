package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_03053_HERMAN {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int R = Integer.parseInt(br.readLine());
		
		double E = R * R * Math.PI;
		double T = R * R * 2;
		
		System.out.printf("%.6f %n", E);
		System.out.printf("%.6f", T);
	}

}
