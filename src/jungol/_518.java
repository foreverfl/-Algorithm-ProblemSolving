package jungol;

import java.util.Scanner;

/* �� ���� ������ �Է� �޾Ƽ� �հ�� ����� ����Ͻÿ�. (�� ����� �Ҽ� ���ϸ� ������ �����κи� ����Ѵ�.)
 * �Է� ��: 10 25 33
 * ��� ��
 * sum : 68
 * avg : 22
 */
public class _518 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt(); 
		int b = scanner.nextInt(); 
		int c = scanner.nextInt(); 
		int sum = a + b + c;
		int avg = sum / 3;
		scanner.close();
		
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);
	}

}
