package JUNGOL;

import java.util.Scanner;

public class _129 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String check;

		do {
			System.out.printf("Base = ");
			int base = sc.nextInt();
			System.out.printf("Height = ");
			int height = sc.nextInt();
			double result = (double) (base * height) / 2;
			System.out.println("Triangle width = " + result);
			System.out.printf("Continue? ");
			check = sc.next();
		} while (check.toUpperCase().equals("Y"));

		
		/*
		 * The 'do ~ while' stops when its value is false.
		 * 
		 * String types compare through '.equals().'
		 * 
		 * 'toUpperCase()' converts a lower case to an upper case.
		 */
	}

}
