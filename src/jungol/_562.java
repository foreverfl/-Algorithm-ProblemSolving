package jungol;

import java.util.Scanner;

public class _562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		int arrEven[] = new int[5];
		int arrOdd[] = new int[5];
		int evenSum = 0;
		int oddSum = 0;
		double oddAvg = 0.0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		// the odd number array(È¦¼ö ¹è¿­)
		for (int i = 0; i < 5; i++) {
			arrOdd[i] = arr[2 * i];
		}

		// the even number array(Â¦¼ö ¹è¿­)
		for (int i = 0; i < 5; i++) {
			arrEven[i] = arr[(2 * i) + 1];
		}
		
		// the average of the odd number array(È¦¼ö ¹è¿­ Æò±Õ)
		for (int a : arrOdd) {
			oddSum += a;
			oddAvg = (double) oddSum / arrOdd.length;
		}
		
		// the sum of the even number array(Â¦¼ö ¹è¿­ ÇÕ)
		for (int a : arrEven) {
			evenSum += a;
		}
		
		System.out.println("sum : " + evenSum);
		System.out.println("avg : " + oddAvg);

	}

}
