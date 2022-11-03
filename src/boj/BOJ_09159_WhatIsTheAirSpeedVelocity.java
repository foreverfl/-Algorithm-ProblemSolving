package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_09159_WhatIsTheAirSpeedVelocity {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<Double> A_list = new ArrayList<>();
		List<Double> E_list = new ArrayList<>();

		DecimalFormat df = new DecimalFormat("0.00");

		int repeat = 20;
		while (repeat-- > 0) {
			st = new StringTokenizer(br.readLine());
			String bird = st.nextToken();
			double fly = Double.parseDouble(st.nextToken());

			if (bird.toLowerCase().equals("a")) {
				A_list.add(fly);
			} else {
				E_list.add(fly);
			}
		}

		double total_A = 0;
		double total_E = 0;
		double total_A_velocity = 0;
		double total_E_velocity = 0;
				
		for (int i = 0; i < 10; i++) {
			total_A += A_list.get(i);
			total_E += E_list.get(i);
			total_A_velocity += A / A_list.get(i);
			total_E_velocity += E / E_list.get(i);
		}		
		

		String velocity_A_1 = df.format(A * 10 / total_A);
		String velocity_E_1 = df.format(E * 10 / total_E);
		String velocity_A_2 = df.format(total_A_velocity / 10);
		String velocity_E_2 = df.format(total_E_velocity / 10);
		
		sb.append("Method 1").append('\n');
		sb.append("African: " +  velocity_A_1 + " furlongs per hour").append('\n');
		sb.append("European: " +  velocity_E_1 + " furlongs per hour").append('\n');		
		sb.append("Method 2").append('\n');
		sb.append("African: " +  velocity_A_2 + " furlongs per hour").append('\n');
		sb.append("European: " +  velocity_E_2 + " furlongs per hour");	
		
		
		System.out.println(sb.toString());
	}

}
