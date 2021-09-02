package jungol;

import java.util.Scanner;

public class temporary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double r = sc.nextDouble();
		sc.close();
		
		System.out.printf("%.2f", r *r * 3.14);
	}

}