package jungol;

import java.util.Scanner;

/* ���� �빮�ڸ� �Է¹޾�  
	 * 'A'�̸� ��Excellent��,
	 * 'B'�̸� ��Good��, 
	 * 'C'�̸� ��Usually��, 
	 * 'D'�̸� ��Effort��, 
	 * 'F'�̸� ��Failure��, 
	 * �� �� �����̸� ��error�� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
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
