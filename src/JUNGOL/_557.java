package JUNGOL;

import java.util.Scanner;

/* 10���� ���ڸ� �Է¹޾Ƽ� ù ��° �� ��° �ϰ� ��° �Է¹��� ���ڸ� ���ʷ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է� ��: A B C D E F G H I J
 * ��� ��: A D G
 */

public class _557 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char arr[] = new char[10];
				
		for (int i=0; i<arr.length; i++) {
			arr[i] = scanner.next().charAt(0); 
		}
		scanner.close();
		/* 'scanner.nextline' returns all strings input before pressing [Enter].
		 * 'scanner.next' returns all strings input before blank(entering [space]).
		 */
		
		System.out.println(arr[0] + " " + arr[3] + " " + arr[6]);

	}

}