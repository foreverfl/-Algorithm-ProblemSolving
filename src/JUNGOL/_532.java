package JUNGOL;

import java.util.Scanner;

/*�� ���� �Ǽ��� �Է¹޾� ��� 4.0 �̻��̸� "A", ��� 3.0 �̻��̸� "B", �ƴϸ� "C" ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 */

public class _532 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		sc.close();
		
		if(a>=4.0 && b>=4.0) {
			System.out.println("A");
		} else if(a>=3.0 && b>=3.0) {
			System.out.println("B");
		} else {
			System.out.println("C");
		}
		
	}

}
