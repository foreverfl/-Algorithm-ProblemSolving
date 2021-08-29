package jungol;

import java.util.Scanner;

/* 영문 대문자를 입력받아  
	 * 'A'이면 “Excellent”,
	 * 'B'이면 “Good”, 
	 * 'C'이면 “Usually”, 
	 * 'D'이면 “Effort”, 
	 * 'F'이면 “Failure”, 
	 * 그 외 문자이면 “error” 라고 출력하는 프로그램을 작성하시오.
	 * 
	 */
public class _534 {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		char score = sc.next().charAt(0);
		sc.close();
		
		switch(score) {
		case 'A':
		 System.out.println("Excellent");
		 break;
		 
		case 'B':
			 System.out.println("Good");
			 break;
			 
		case 'C':
			 System.out.println("Usually");
			 break;
			 
		case 'D':
			 System.out.println("Effort");
			 break;
			 
		case 'F':
			 System.out.println("Failure");
			 break;
		default :
			 System.out.println("error");
		}
		 
	}
}
