package jungol;

import java.util.Scanner;

/*�� ���� ������ �Է¹޾Ƽ�,  
 * ù ��° �ٿ��� �� ������ ���� ������ 1 �ƴϸ� 0�� ����ϰ�, 
 * �� ��° �ٿ��� ���� ������ 1 ������ 0�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * (JAVA�� 1�̸� true, 0�̸� false�� ����Ѵ�.)
 * �Է� ��: 5 5 
 * ��� ��: 1
 *        0
*/
public class _522 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		scanner.close();
		
		if (a == b) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
	
		if (a != b) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
