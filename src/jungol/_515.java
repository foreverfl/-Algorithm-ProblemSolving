package jungol;

import java.util.Scanner;

/* 두 개의 정수를 입력 받아 곱과 몫을 출력하시오.
 * (먼저 입력 받는 수가 항상 크며 입력되는 두 정수는 1이상 500이하이다.)
 */

public class _515 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		
		int result1 = a * b;
		int result2 = a / b;
		
		System.out.println(a + " * " + b + " = " + result1);
		System.out.println(a + " / " + b + " = " + result2);
	}

}
