package jungol;

import java.util.Scanner;

public class _128 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int check = 0;
		
		while(run) {
			int a = sc.nextInt();
			if(a%3 != 0 && a%5 !=0 ) {
				check++;
			}
			if(a == 0)
				break;
		}
		sc.close();
		System.out.println(check);
	}

}
