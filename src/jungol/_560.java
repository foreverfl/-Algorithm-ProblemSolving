package jungol;

import java.util.Scanner;

/*10���� ������ �Է¹޾� �� �� ���� ���� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.(�Է¹��� ������ 1000�� ���� �ʴ´�.)
 * �Է� ��: 5 10 8 55 6 31 12 24 61 2 
 * ��� ��: 2
 */
public class _560 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arr [] = new int[10];
		for(int i=0; i<arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		scanner.close();
		
		int min = 1000; // The minimum value is initialized as 1000.
		int max = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println(min);
		System.out.println(max);
	}

}
