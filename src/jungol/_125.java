package jungol;

import java.util.Scanner;

/* ������ �Է¹޾� 1���� �Է¹��� ���������� ���ʴ�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է� ��: 5
 * ��� ��: 1 2 3 4 5
 */

public class _125 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputInt = sc.nextInt();
		int arr [] = new int[inputInt]; 
		sc.close();
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " "); 
 		}
		 
	}

}
