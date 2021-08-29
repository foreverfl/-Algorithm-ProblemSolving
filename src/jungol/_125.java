package jungol;

import java.util.Scanner;

/* 정수를 입력받아 1부터 입력받은 정수까지를 차례대로 출력하는 프로그램을 작성하시오.
 * 입력 예: 5
 * 출력 예: 1 2 3 4 5
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
