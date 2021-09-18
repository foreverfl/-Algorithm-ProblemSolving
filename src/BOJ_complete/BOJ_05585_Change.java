package BOJ_complete;

import java.util.Scanner;

public class BOJ_05585_Change {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int change = 1000 - input;
		int count = 0;
		if (change >= 500) {
			count += (change / 500);
			change = change % 500;
		} 
		
		if (change >= 100) {
			count += (change / 100);
			change = change % 100;
		} 
		
		if (change >= 50) {
			count += (change / 50);
			change = change % 50;
		} 
		
		if (change >= 10) {
			count += (change / 10);
			change = change % 10;
		} 
		
		if (change >= 5) {
			count += (change / 5);
			change = change % 5;
		} 
		
		if (change >= 1) {
			count += (change / 1);
			change = change % 1;
		}

		System.out.println(count);

	}

}
