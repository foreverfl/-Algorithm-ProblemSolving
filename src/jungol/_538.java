package jungol;

import java.util.Scanner;

/* �� ���� ������ �Է¹޾� ���(positive integer)���� ����(negative number)���� ����ϴ� �۾��� �ݺ��ϴٰ� 0�� �ԷµǸ� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 */

public class _538 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num;
		do {
			System.out.print("number? ");
			num = sc.nextInt();
			if(num > 0) {
				System.out.println("positive integer");
			} else if (num < 0){
				System.out.println("negative number");
			} else {
				num = 0;
			}
		} while (num != 0);
		sc.close();
		

	}

}
