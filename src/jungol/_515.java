package jungol;

import java.util.Scanner;

/* �� ���� ������ �Է� �޾� ���� ���� ����Ͻÿ�.
 * (���� �Է� �޴� ���� �׻� ũ�� �ԷµǴ� �� ������ 1�̻� 500�����̴�.)
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
