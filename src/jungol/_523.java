package jungol;

import java.util.Scanner;

/* �� ���� ������ �Է¹޾Ƽ� ������ ���� 4���� ���迬������ ����� ����Ͻÿ�. 
 * �̶� �Է¹��� �� ������ �̿��Ͽ� ����Ͻÿ�. 
 *  (JAVA�� 1�̸� true, 0�̸� false�� ����Ѵ�.)
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
