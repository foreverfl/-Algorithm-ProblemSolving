package jungol;

import java.util.Scanner;

/*Ű�� �Է¹޾� ����ϴ� ���α׷��� �ۼ��϶�.
(�Է��Ҷ� "height = " ������ ���� ����ϰ� Ű�� �Է� �޾ƾ� �մϴ�.)
�Է¿� : height = 170
��¿� : Your height is 170cm.


*/
public class _514 {

	public static void main(String[] args) {
		System.out.print("height = ");		
		
		Scanner scanner = new Scanner(System.in);
		int height = scanner.nextInt();
		scanner.close();
		
		System.out.println("Your height is " + height + "cm.");
		

	}

}
