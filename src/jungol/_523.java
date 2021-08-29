package jungol;

import java.util.Scanner;

/* 두 개의 정수를 입력받아서 다음과 같이 4가지 관계연산자의 결과를 출력하시오. 
 * 이때 입력받은 두 정수를 이용하여 출력하시오. 
 *  (JAVA는 1이면 true, 0이면 false를 출력한다.)
 *  4 > 5 --- 0 
 *  4 < 5 --- 1
 *  4 >= 5 --- 0
 *  4 <= 5 --- 1
 */
public class _523 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		
		  System.out.println(a + " > " + b + " --- " + (a>b));
		  System.out.println(a + " < " + b + " --- " + (a<b));
		  System.out.println(a + " >= " + b + " --- " + (a>=b));
		  System.out.println(a + " <= " + b + " --- " + (a<=b)); // A value of operation result is a boolean value.
		  
	}

}
